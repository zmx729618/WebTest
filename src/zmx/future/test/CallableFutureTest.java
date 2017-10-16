package zmx.future.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableFutureTest {
	
	public static void main(String[] args) throws Exception {
		Callable<Integer> func = new Callable<Integer>(){ 
		    public Integer call() throws Exception { 
		        System.out.println("inside callable"); 
		        Thread.sleep(1000); 
		        return new Integer(8); 
		    }        
		};       
		FutureTask<Integer> futureTask  = new FutureTask<Integer>(func); 
		Thread newThread = new Thread(futureTask); 
		newThread.start(); 
	  //Thread.sleep(2000);
		try { 
		    System.out.println("blocking here"); 
		    Integer result = futureTask.get(); 
		    System.out.println(result); 
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	

}
