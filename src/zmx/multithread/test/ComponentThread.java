package zmx.multithread.test;

public class ComponentThread implements Runnable {

    private ServerThread server;
    
    public ComponentThread(ServerThread server) {
          this.server = server;
    }

    public void run() {
          //做组件初始化的工作
          System.out.println("Do component initialization.");
          server.callBack();
    }

}
