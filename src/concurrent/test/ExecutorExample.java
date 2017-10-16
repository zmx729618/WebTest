package concurrent.test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.core.task.SimpleAsyncTaskExecutor;


public class ExecutorExample {
	
	private Executor executor;
	
	public void setExecutor(Executor executor){
		this.executor = executor;
	}
	
	public void executeTasks(){
		for(int i=0;i<6;i++){
			executor.execute(new SimpleTask("task"+i));
		}
	}
	
	public static void main(String[] args){
		ExecutorExample ee = new ExecutorExample();
		ee.setExecutor(Executors.newFixedThreadPool(3));
	//	ee.setExecutor(new SimpleAsyncTaskExecutor());
		ee.executeTasks();			
	}
	
	
	class SimpleTask implements Runnable{
		
		private String taskName;
		
		public SimpleTask(String taskName){
			this.taskName = taskName;
		}

		@Override
		public void run() {
			System.out.println("do"+taskName+" in Thread:"+Thread.currentThread().getId());
		}
		
	}

}
