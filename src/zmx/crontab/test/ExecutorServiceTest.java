package zmx.crontab.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();

		List<Future<String>> resultList = new ArrayList<Future<String>>();
		
		for(int i=0;i<10;i++){
            // 使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中  
            Future<String> future = (Future<String>) executorService.submit(new TaskWithResult(i));  
            // 将任务执行结果存储到List中  
            resultList.add(future); 			
		}
		
		executorService.shutdown();  //以及提交的任务会继续执行		
		for (Future<String> fs : resultList) {  
	        try {  
		            System.out.println(fs.get()); // 打印各个线程（任务）执行的结果  
	            } catch (InterruptedException e) {  
		            e.printStackTrace();  
	            } catch (ExecutionException e) {  
	                executorService.shutdownNow();  //立即终止所有任务
	                e.printStackTrace();  
	                return;  
	            }  
        }
				
		
	}

}
