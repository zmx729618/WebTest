package concurrent.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyExecutor extends Thread {
		private int index;
		public MyExecutor(int i) {
			this.index = i;
		}
		public void run() {
			try {
				System.out.println("[" + this.index + "] start....");
				Thread.sleep((int) (Math.random() * 10000));
				System.out.println("[" + this.index + "] end.");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	/*	public static void main(String args[]) {
			
			ExecutorService service = Executors.newFixedThreadPool(4);
			
			
			for (int i = 0; i < 10; i++) {
				service.execute(new MyExecutor(i));
				// service.submit(new MyExecutor(i));
			}
			System.out.println("submit finish");
			service.shutdown();
		}*/
		
	    public static void main(String[] args) throws InterruptedException, ExecutionException {  
	          
	        final ExecutorService exe=Executors.newFixedThreadPool(3);  
	        Callable<String> call=new Callable<String>(){  
	            public String call() throws InterruptedException {  
	            	 Thread.sleep(10000);
	            	return "Thread is finished";  
	               
	            }  
	        };  
	        Future<String> task=exe.submit(call);  
	        String obj=task.get();  
	        System.out.println(obj+"进程结束");  
	        System.out.println("总进程结束");  
	        exe.shutdown();  
	    } 	

	

}
