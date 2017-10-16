package zmx.multithread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
	
	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	/*	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
		
		for(int i=0;i<100;i++){
			
			Runnable task = new Runnable() { 
			    @Override
			    public void run() { 
			        System.out.println("task over"); 
			    } 
			}; 
			fixedThreadPool.execute(task); 
		}*/

		  
		ScheduledExecutorService  scheduledThreadPool  =  Executors.newScheduledThreadPool(10);
		for(int i=0;i<10;i++){
			
			Runnable task = new Runnable() { 
			    @Override
			    public void run() { 
			        System.out.println("task over"); 
			    } 
			}; 
			scheduledThreadPool.scheduleAtFixedRate(task, 10, 10, TimeUnit.SECONDS);
		} 
		
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		
	}

}
