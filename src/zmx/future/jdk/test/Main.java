package zmx.future.jdk.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		FutureTask<String> future = new FutureTask<String>(new RealData("name"));
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		

		executor.submit(future);
		
		System.out.println("请求完毕");
		
		try{
			Thread.sleep(2000);
		}catch (Exception e) {
			
		}
		System.out.println("数据="+future.get());
		
	}

}
