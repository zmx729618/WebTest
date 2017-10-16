package zmx.multithread.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;








public class TaskTest {
	
    private static void testNoThreadTask() throws Exception {

        long t1 = System.currentTimeMillis();

        for (int k = 0; k < 10; k++) {

            // 这是一个耗时的工作
            Thread.sleep((k + 1) * 500);

            System.out.println(" k=" + k);

            System.out.println("k=" + k + " success");

        }

        System.out.println(" times :");

        System.out.println(System.currentTimeMillis() - t1);

    }
    
    
    private static void testThreadTask(){


        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(2);

        executor.setMaxPoolSize(4);

        executor.setKeepAliveSeconds(120);

        executor.setQueueCapacity(32);

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        executor.initialize();

         

        List<Future<String>> taskResults = new ArrayList<Future<String>>();

        long t1 = System.currentTimeMillis();

        for(int k=0; k<10; k++){

            taskResults.add(process(executor, k));

        }

        System.out.println("task doing ...");
        
        while (true) {

            boolean isAllDone = true;

            for (Future<String> taskResult : taskResults) {

                isAllDone &= ( taskResult.isDone() || taskResult.isCancelled() );

            }

            if (isAllDone) {

                // 任务都执行完毕，跳出循环

                break;

            }

            try {

                System.out.println("waiting and sleep 1000 ...");

                TimeUnit.MILLISECONDS.sleep(1000);

            } catch (Exception e) {

                System.out.println(e.toString());

                break;

            }

        }


         

        for(Future<String> taskResult : taskResults){

            String ex;

            try {

                ex = taskResult.get();

            } catch (Exception e) {

                ex = e.getMessage();

            }

            if(StringUtils.isNotEmpty(ex)){

                System.out.println(ex);

            }

        }

        System.out.println(" times :");

        System.out.println(System.currentTimeMillis()-t1);

    }


    private static Future<String> process(final ThreadPoolTaskExecutor executor , final int k) {
    	
        return executor.submit(new Callable<String>() {

            @Override

            public String call() throws Exception {

                try {

                    Thread.sleep((k+1)*500);

                    System.out.println(" k=" + k);

                } catch (Exception e) {

                    return e.getMessage();

                }

                return "k=" + k + " success";

            }

        });

    }




	
	
	
	
	public static void main(String[] args) throws Exception {
		
	
        System.out.println("testNoThreadTask begin ...");

        testNoThreadTask();

        System.out.println("testThreadTask begin ...");

        testThreadTask();


		
		
	}

}
