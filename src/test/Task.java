package test;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task {
	//模拟一个复杂计算
	public void doSomething(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		StringBuffer sb =  new StringBuffer();
		
		sb.append("线程名称:"+ Thread.currentThread().getName());
		
		sb.append("，执行时间:"+ Calendar.getInstance().get(Calendar.SECOND));
		
		System.out.println(sb);
	}
	
	
	
	public static void runTasks(Class<? extends Runnable> clazz) throws Exception{
		ExecutorService es =  Executors.newCachedThreadPool();
		System.out.println("开始执行"+clazz.getSimpleName()+"任务...");
		for(int i=0; i<3; i++){
			es.submit(clazz.newInstance());
		}
		
		TimeUnit.SECONDS.sleep(10); //等待足够长的时间
		
		System.out.println("执行完毕"+clazz.getSimpleName()+"任务...");
		
		es.shutdown();
	}
	
	
	public synchronized void m2(){
		try {
			Thread.sleep(2000);
			System.out.println("m2执行完毕");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public synchronized void m1(){
    	try {
			Thread.sleep(2000);
			System.out.println("m1执行完毕");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
	//	runTasks(TaskWithLock.class);
	//	runTasks(TaskWithSync.class);
		
		final Task t = new Task();
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.m1();
				
			}
		});
		
		th.start();
		
		t.m2();
		
	}

}
