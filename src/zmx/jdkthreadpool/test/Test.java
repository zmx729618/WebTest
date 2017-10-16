package zmx.jdkthreadpool.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 测试-----
 * @author zhangwenchao
 *
 */
public class Test {
	
    private final static ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
            	
            	
            	/**
            	 * 捕获异常------正常周期执行
            	 */
                /*try {
                    int[] s = new int[1];
                    System.out.println("OK");
                    System.out.println(s[1]); // 数组越界
                } catch (Throwable t) {
                    System.out.println("Error");
                    
                }*/
                
                
                    /**
                     * 未捕获异常------不会定期执行，阻塞
                     */
                    int[] s = new int[1];
                    System.out.println("OK");
                    System.out.println(s[1]); // 数组越界
                  
           

            }
        }, 0, 2, TimeUnit.SECONDS);
    }
    /**
     * 关闭线程池
     * @param pool
     */
    static void shutdownAndAwaitTermination(ExecutorService pool) {  
    	  pool.shutdown(); // Disable new tasks from being submitted  
    	  try {  
    	    // Wait a while for existing tasks to terminate  
    	    if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {  
    	      pool.shutdownNow(); // Cancel currently executing tasks  
    	      // Wait a while for tasks to respond to being cancelled  
    	      if (!pool.awaitTermination(60, TimeUnit.SECONDS))  
    	          System.err.println("Pool did not terminate");  
    	    }  
    	  } catch (InterruptedException ie) {  
    	    // (Re-)Cancel if current thread also interrupted  
    	    pool.shutdownNow();  
    	    // Preserve interrupt status  
    	    Thread.currentThread().interrupt();  
    	  }  
    }  



}
