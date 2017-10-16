package zmx.multithread.test.threadinterrupt;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;  
import java.util.concurrent.TimeUnit;  
public class ThreadPoolTest {  
    public static void main(String[] args) {  
        ScheduledExecutorService schedulePool = Executors.newScheduledThreadPool(2);  
        // 5秒后执行任务  
        schedulePool.schedule(new Runnable() {  
            public void run() {  
                System.out.println("爆炸");  
            }  
        }, 5, TimeUnit.SECONDS);  
        // 5秒后执行任务，以后每2秒执行一次  
        schedulePool.scheduleAtFixedRate(new Runnable() {  
            @Override  
            public void run() {  
                System.out.println("爆炸");  
            }  
        }, 5, 2, TimeUnit.SECONDS);  
    }  
} 

