package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AsyncTestThread implements Callable<Integer>{
    private static Object result;
	//本金
	private int seedMoney;
	
	public AsyncTestThread(int seedMoney) {
		this.seedMoney = seedMoney;
	}
	
	@Override
	public Integer call() throws Exception {
		TimeUnit.MILLISECONDS.sleep(5000);  //复杂运算---休眠5s
		return seedMoney/10;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		//生成一个单线程的异步执行器
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		//线程执行后的期望值
		Future<Integer> future = executorService.submit(new AsyncTestThread(1000));

		while(!future.isDone()){//如果运算还没有完成
			//等待200ms
			Thread.sleep(200);  
			System.out.print("#");
		}
	
		
		try {
			Integer result = future.get();
			System.out.println("\n计算完成,税金为："+result);
			executorService.shutdown();
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}
		
	}

}
