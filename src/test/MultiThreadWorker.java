package test;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * @author zhangwenchao
 *
 */
public class MultiThreadWorker implements Runnable{
	private CyclicBarrier cbarrier;  //关卡
	
	public MultiThreadWorker(CyclicBarrier cbarrier) {
		this.cbarrier = cbarrier;
	}
	
	@Override
	public void run(){
		try {
			Thread.sleep(new Random().nextInt(3000));
			System.out.println(Thread.currentThread().getName()+"-到达汇合点");
			cbarrier.await();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//设置汇集数量，以及汇集完成后的任务
		CyclicBarrier cb = new CyclicBarrier(2, new Runnable() {
			@Override
			public void run() {
				
				System.out.println("隧道已经打通");
			}
		});
		
		
		new Thread(new MultiThreadWorker(cb), "worker1").start();
		new Thread(new MultiThreadWorker(cb), "worker2").start();

	}



}
