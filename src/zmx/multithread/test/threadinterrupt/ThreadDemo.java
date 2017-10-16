package zmx.multithread.test.threadinterrupt;

public class ThreadDemo {
	
    public static void main(String[] args){    
               Runnable r=new TestRunnable();    
               Thread th1=new Thread(r);    
               th1.start();    
               th1.interrupt();             
    } 

}


//无法中断正在运行的线程代码    
class TestRunnable implements Runnable{    
      public void run(){    
            try {
				while(!Thread.currentThread().isInterrupted()){    
				      System.out.println( "Thread is running..." );    
				      long time = System.currentTimeMillis();//去系统时间的毫秒数    
				      while((System.currentTimeMillis()-time < 1000)) {    
				       //程序循环1秒钟，不同于sleep(1000)会阻塞进程。    
				       }    
				}
				System.out.println("线程遇到中断标志，退出");
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				
			}    
       }    
} 
