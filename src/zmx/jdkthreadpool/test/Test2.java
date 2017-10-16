package zmx.jdkthreadpool.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
	
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		executorService.execute(new  Runnable() {
			
			@Override
			public void run() {				   
		        for (int i = 0; i < 10; i++) {
	                System.out.println(Thread.currentThread().getName() + " 执行 - " + i);
		        }
	
			}
		});
	}

}
