package concurrent.test;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * CompletionService相当于Executor加上BlockingQueue，
 * 使用场景为当子线程并发了一系列的任务以后，
 * 主线程需要实时地取回子线程任务的返回值并同时顺序地处理这些返回值，
 * 谁先返回就先处理谁.
 * @author zhangwenchao
 *
 */
public class MyCompletionService implements Callable<String> {
    
	private int id;  
    public MyCompletionService(int id) {  
        this.id = id;  
    }
	
	
	@Override
	public String call() throws Exception {
		Integer time = (int) (Math.random() * 1000);  
        try {  
            System.out.println(this.id + " start");  
            Thread.sleep(time);  
            System.out.println(this.id + " end");  
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
        return this.id + ":" + time;  
	}
	
	
    public static void main(String[] args) throws Exception {  
        ExecutorService service = Executors.newCachedThreadPool();  
        CompletionService<String> completion = new ExecutorCompletionService<String>(service);  
        for (int i = 0; i < 10; i++) {  
            completion.submit(new MyCompletionService(i));  
        }  
          
        for (int i = 0; i < 10; i++) {  
            System.out.println(completion.take().get());  
        }  
        service.shutdown();  
    } 

}
