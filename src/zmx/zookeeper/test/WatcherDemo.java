package zmx.zookeeper.test;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

/**
 * 
 * @description Zookeeper Watcher演示类
 * @author zhangchaoyang
 * @date 2014-6-22
 */
public class WatcherDemo {
    private static ZooKeeper zkp = null;
    private static final int TIMEOUT = 6000;

    private static Watcher getWatcher(final String msg) {
        return new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println(msg + "上的监听被触发\t事件类型" + event.getType()
                        + "\t发生变化的节点" + event.getPath());
            }
        };
    }

    public static void main(String[] args) throws IOException, KeeperException,
            InterruptedException {
        System.out.println("--------------1----------------");
        zkp = new ZooKeeper("192.168.152.201:2181", TIMEOUT,getWatcher("CONNECT"));
        Thread.sleep(1000);
        
        System.out.println("--------------2----------------");
        zkp.create("/znodename", "znodedata".getBytes(), Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        zkp.create("/znodename/childnode", new byte[0], Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        Stat stat = zkp.exists("/znodename", getWatcher("EXISTS"));
        zkp.getChildren("/", getWatcher("GETCHILDREN"));
        zkp.getData("/znodename", getWatcher("GETDATA"), stat);

        stat = zkp.exists("/znodename/childnode", getWatcher("EXISTS"));
        zkp.getChildren("/znodename", getWatcher("GETCHILDREN"));
        zkp.getData("/znodename/childnode", getWatcher("GETDATA"), stat);

        zkp.close();
        zkp = new ZooKeeper("192.168.152.201:2181", TIMEOUT,getWatcher("CONNECT"));
        Thread.sleep(1000);

        System.out.println("--------------3----------------");
        zkp.delete("/znodename/childnode", -1);
        zkp.delete("/znodename", -1);
        zkp.close();
    }
}
