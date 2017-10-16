package zmx.thread.pool.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import zmx.concurrent.test.SynchronousQueueTest;

public class Main {
	
	static class MyThread implements Runnable{
		
		protected String name;
		
		public MyThread() {
			
		}
        public MyThread(String name) {
			this.name = name;
		}

		@Override
		public void run() {
		
			try {
				Thread.sleep(1000);
				System.out.println(name+"线程执行完毕");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
	
		
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=0; i<1000; i++){
			es.execute(new MyThread("testJDkThreadPool"+i));
		}
	
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		
/*		for (int i = 0; i < 10; i++) {  
		   final int index = i;  
		   fixedThreadPool.execute(new Runnable() {  
			    public void run() {  
				     try {  
				         System.out.println(index);  
				         Thread.sleep(2000);  
				     } catch (InterruptedException e) {  
				         e.printStackTrace();  
				     }  
			    }  
		   });  
	    }  */

		
	}
	
	

}
