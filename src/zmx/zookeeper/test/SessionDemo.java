package zmx.zookeeper.test;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.KeeperException.ConnectionLossException;
import org.apache.zookeeper.KeeperException.SessionExpiredException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.ZooKeeper;

/**
 * 
 * @description Zookeeper Session演示类
 * @author zhangchaoyang
 * @date 2014-6-22
 */
public class SessionDemo {
    /**
     * zoo.cfg中的配置：
     * 
     * <pre>
     * tickTime=2000
     * minSessionTimeout=4000（至少是tickTime的2倍）
     * maxSessionTimeout=40000（最大是tickTime的20倍）
     * </pre>
     * 
     * 如果客户端建立连接时指定的TIMEOUT不在[minSessionTimeout,maxSessionTimeout]区间内，
     * 服务端会强制把它修改到该区间内
     */
    private static final int TIMEOUT = 40000; // Session
                                                // Timeout设为40秒，因为心跳周期为2秒，所以如果server向client连续发送20个心跳都收不到回应，则Session过期失效
    private static ZooKeeper zkp = null;

    private static void connect() throws IOException {
        zkp = new ZooKeeper("192.168.152.201:2181", TIMEOUT, null);
    }

    private static void createNode() throws KeeperException,
            InterruptedException {
        if (zkp != null) {
            zkp.create("/znodename", "znodedata".getBytes(),
                    Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        }
    }

    private static String getData() throws KeeperException,
            InterruptedException {
        if (zkp != null) {
            Stat stat = zkp.exists("/znodename", false);
            return new String(zkp.getData("/znodename", false, stat));
        }
        return null;
    }

    private static void disconnect() throws InterruptedException {
        if (zkp != null) {
            zkp.close();
        }
    }

    /**
     * 休息，在此期间我们有三种选择：<br>
     * <ol>
     * <li>永久性断开网络连接
     * <li>断开网络连接一段时间timespan后再连上，其中timespan<{@code TIMEOUT}
     * <li>断开网络连接一段时间timespan后再连上，其中timespan>{@code TIMEOUT}
     * </ol>
     */
    private static void sleepForNetworkDisturbances() {
        try {
            Thread.sleep(2 * TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            connect();
        } catch (IOException e) {
            System.err
                    .println("Can't create zookeeper client, please check the network.");
        }
        System.out.println("Session build.");

        try {
            createNode();
        } catch (Exception e) {
            System.err.println("Create znode failed.");
        }
        System.out.println("znode created.");

        sleepForNetworkDisturbances();

        try {
            String data = getData();
            if (data != null) {
                // 在“休息”期间做了第2件事情，Sesion没有过期，EPHEMERAL节点依然存在
                System.out.println("data=" + data);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
            // 在“休息”期间做了第1件事情
            if (e instanceof ConnectionLossException) {
                System.err
                        .println("Oops, network is disconnected. Retry getData().");
                // 如果session没有失效，而仅仅是网络异常，则可以重新尝试获取数据，可能在重试时网络已经正常了
                try {
                    Thread.sleep(1000);
                    String data = getData();
                    if (data != null) {
                        System.out.println("data=" + data);
                    } else {
                        System.out.println("can't get data.");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            // 在“休息”期间做了第3件事情，则session会过期
            else if (e instanceof SessionExpiredException) {
                System.err
                        .println("Session Expired, client will reconnect and create znode again.");
                // 当发再Session Expired时，必须重新建立连接，即new一个ZooKeeper
                try {
                    connect();
                    createNode();
                    String data = getData();
                    if (data != null) {
                        System.out.println("data=" + data);
                    } else {
                        System.out.println("can't get data.");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            disconnect();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Client disconnected.");
    }
}
