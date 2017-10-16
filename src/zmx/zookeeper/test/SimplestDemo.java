package zmx.zookeeper.test;
import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

public class SimplestDemo {
	private static final int TIMEOUT = 3000;

    public static void main(String[] args) throws IOException, KeeperException,
            InterruptedException {
        // Client向zookeeper发送连接请求
        ZooKeeper zkp = new ZooKeeper("192.168.152.201:2181", // 指定zookeeper
                                                                        // server的IP、端口列表（当client连接不上server时会按照此列表尝试连接下一台server），以及默认的根目录
                TIMEOUT,// Session Timeout
                null// 是否设置监听器
        );

        zkp.create("/znodename", // 节点名称
                "znodedata".getBytes(), // 节点上的数据
                Ids.OPEN_ACL_UNSAFE,// ACL
                CreateMode.EPHEMERAL// 节点类型，有三种：PERSISTENT、EPHEMERAL、SEQUENTIAL。EPHEMERAL节点不允许有子节点
        );

        Stat stat = zkp.exists("/znodename",// 节点名，如果节点不存在，则exists()返回null
                false// 是否设置监听器
                );
        if (zkp.exists("/znodename", false) != null) {
            System.out.println("znodename exists now.");
        }

        // 修改节点上存储的数据，需要提供version，version设为-1表示强制修改
        zkp.setData("/znodename", "newdata".getBytes(), stat.getVersion());

        // 读取节点上的数据
        String data = new String(zkp.getData("/znodename", false, stat));
        System.out.println(data);

        // client端主动断开连接
        zkp.close();
    }


}
