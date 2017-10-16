package zmx.thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest{
	public static void main(String[] args) {
		
		final Business business = new Business();
				
		/**
		 * 该代码必须子线程先执行，否则会出现死锁现象
		 */
		
		//子线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				threadExecute(business, "sub");
			}
		}).start();
		
		
		//主线程
		threadExecute(business, "main");
		
		
		
	}
	
	/**
	 * 执行线程
	 * @param business
	 * @param threadType
	 */
	public static void threadExecute(Business business, String threadType) {
		for(int i = 0; i < 100; i++) {
			try {
				if("main".equals(threadType)) {
					business.main(i); 
				} else {
					business.sub(i); 
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class Business {
	private boolean bool = true;
	private Lock lock = new ReentrantLock();  //重入锁
	private Condition condition = lock.newCondition(); //使用锁生成一个Condition实例
	
	/**
	 * 主线程打印序列
	 * @param loop
	 * @throws InterruptedException
	 */
	public /*synchronized*/ void main(int loop) throws InterruptedException {
		lock.lock();
		try {
			while(bool) {  //此处本人测试也可以使用if，但是高手都用while，
				//线程等待
				condition.await();//this.wait();  
			}
			for(int i = 0; i < 100; i++) {
				System.out.println("main thread seq of " + i + ", loop of " + loop);
			}
			Thread.sleep(1000);
			bool = true;
			condition.signal();//this.notify();
		} finally {
			lock.unlock();
		}
	}
	
	
	/**
	 * 子线程打印序列
	 * @param loop
	 * @throws InterruptedException
	 */
	public /*synchronized*/ void sub(int loop) throws InterruptedException {
		lock.lock();
		try {
			while(!bool) {//此处本人测试也可以使用if，但是高手都用while，
				condition.await();//this.wait();
			}
			for(int i = 0; i < 10; i++) {
				System.out.println("sub thread seq of " + i + ", loop of " + loop);
			}
			Thread.sleep(1000);
			bool = false;
			condition.signal();//this.notify();
		} finally {
			lock.unlock();
		}
	}
}
