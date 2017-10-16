package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncControlTest {

	//线程池
	private ExecutorService executorService;

	//保存异步计算的Future<T>列表
	private FutureContext<String> context;

	public AsyncControlTest() {
	//	this.executorService = Executors.newScheduledThreadPool(10);		
		this.executorService = Executors.newFixedThreadPool(10);
		this.context = new FutureContext<String>();
	}



	public FutureContext<String> getFutureContext() {
		return this.context;
	}

	/**
	 * 处理所有任务
	 */
	public void startAsyncCompution() {
		/**
		 * 开启100个异步计算，每个异步计算线程随机sleep几秒来模拟计算耗时。
		 */
		final Random random = new Random();
		for (int i = 0; i < 100; i++) {
			Future<String> future = this.executorService
					.submit(new Callable<String>() {
						@Override
						public String call() throws Exception {
							int randomInt = random.nextInt(10);
							Thread.sleep(randomInt * 1000);
							return "" + randomInt;
						}
					});
			//每个异步计算的结果存放在context中
			this.context.addFuture(future);
		}
	}
	
	
    /**
     * 内部类，定义一个Future<T> 列表
     * @author zhangwenchao
     * @param <T>
     */
	public static class FutureContext<T> {

		private List<Future<T>> futureList = new ArrayList<Future<T>>();

		public void addFuture(Future<T> future) {
			this.futureList.add(future);
		}

		public List<Future<T>> getFutureList() {
			return this.futureList;
		}
	}
	
	
    /**
     * 内部类：处理异步结果的线程类
     * @author zhangwenchao
     *
     */
	public static class OutputResult implements Runnable {

		private FutureContext<String> context;

		public void setFutureContext(FutureContext<String> context) {
			this.context = context;
		}

		@Override
		public void run() {
			System.out.println("start to output result:");
			List<Future<String>> list = this.context.getFutureList();

			for (Future<String> future : list) {
				this.outputResultFromFuture(future);
			}

			System.out.println("finish to output result.");
			System.exit(0);
		}

		private void outputResultFromFuture(Future<String> future) {
			try {
				while (true) {
					if (future.isDone() && !future.isCancelled()) {
						System.out.println("Future:" + future + ",Result:"
								+ future.get());
						break;
					} else {
						Thread.sleep(1000);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		//启动异步计算
		AsyncControlTest controller = new AsyncControlTest();
		controller.startAsyncCompution();

		//启动异步计算结果输出线程，该线程扫描异步计算Futrue的状态，如果已经完成，则输出异步计算结果
		OutputResult output = new OutputResult();
		output.setFutureContext(controller.getFutureContext());
		Thread resultThread = new Thread(output);
		resultThread.start();
	}
	
	
	
	
	
	
	
}

