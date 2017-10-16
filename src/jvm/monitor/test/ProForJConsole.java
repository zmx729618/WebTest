package jvm.monitor.test;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import jline.internal.InputStreamReader;


public class ProForJConsole {
	/**
	 * 内存占位符对象，一个OOMObject对象大约占64K
	 * @author zhangwenchao
	 *
	 */
	static class OOMObject{
		
		public  byte[] placeholder =  new byte[64*1024];
		
		
	}
	
	/**
	 * 堆区内存测试
	 * @param num
	 * @throws Exception
	 */
	public static void fillHeap(int num) throws Exception{
		
		List<OOMObject> list =  new ArrayList<OOMObject>();
		for(int i=0; i<num;i++){
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.gc();
		
	}
	
	/**
	 * 线程死循环测试
	 */
	public static void createBusyThread(){
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					;
				}
				
			}
		},"testBusyThread");
		
		thread.start();
		
	}
	
	
	/**
	 * 线程锁等待演示
	 */
	public static void createLockThread(final Object lock){
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized(lock){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
				}	
			}
		},"testLockThread");
		
		thread.start();
	}
	
	
	
	static class SyncAddRunable implements Runnable{
        
		int a, b;
        
		public SyncAddRunable(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public void run() {
			
			synchronized(Integer.valueOf(a)){
				
				synchronized (Integer.valueOf(b)) {
					
					System.out.println(a+b);
					
				}
				
			}
		}
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		 fillHeap(1000);   //堆内存测试
		
		/*
	    BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		br.readLine();
		
		createBusyThread();   //线程死循环
		
		br.readLine();
		
		Object obj =  new Object();
		
		createLockThread(obj);  //线程所等待
		
       */	
		
		
		/*for(int i=0; i<100;i++){
			System.out.println("线程数："+i);
			new Thread(new SyncAddRunable(1, 2)).start();
			new Thread(new SyncAddRunable(2, 1)).start();
			
		}*/
		
	}

}
