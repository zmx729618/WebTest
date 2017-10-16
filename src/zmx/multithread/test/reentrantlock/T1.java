package zmx.multithread.test.reentrantlock;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class T1 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

				ExecutorService executor = Executors.newCachedThreadPool();
				for(int i=0; i<5; i++) {
					Callable<String> c = new Task();
					MyFutureTask ft = new MyFutureTask(c);
					executor.submit(ft);
				}
				executor.shutdown();
			}
				
		}

		class MyFutureTask extends FutureTask<String> {

			public MyFutureTask(Callable<String> callable) {
				super(callable);
			}

			@Override
			protected void done() {
				try {
					System.out.println(get() + " 线程执行完毕！~");
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}

		class Task implements Callable<String> {

			@Override
			public String call() throws Exception {
				Random rand = new Random();
				TimeUnit.SECONDS.sleep(rand.nextInt(12));
				return Thread.currentThread().getName();
			}
		
		
		/*ExecutorService executor= Executors.newSingleThreadExecutor();  		 
		executor.submit(new FutureTask<String>(new Callable<String>(){
			@Override
			public String call() throws Exception {
				
				        Random rand = new Random();  
				        TimeUnit.SECONDS.sleep(rand.nextInt(12));  
				        return Thread.currentThread().getName();

			}}){

				@Override
				protected void done() {
					
					try {
						String result = this.get();
						System.out.println(result);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					} catch (ExecutionException e) {
						
						e.printStackTrace();
					}
					
					System.out.println("执行完毕");
				}
			 
		 });
		executor.shutdown();*/	
		
		/* ExecutorService executor2= Executors.newFixedThreadPool(5); 		 
		 class Task implements Callable<String>{
			@Override
			public String call() throws Exception {
				
				Random rand = new Random();  
		        TimeUnit.SECONDS.sleep(rand.nextInt(10));  
		        return  Thread.currentThread().getName();
			}			 
		 }
		 
		 List<Future<String>> results = new ArrayList<Future<String>>();
		 for(int i=0;i<5;i++){
			 Future<String> f =  executor2.submit(new Task());
			 results.add(f);
		 }
 
		 boolean flag =true; 
		 while(flag) {
			
			for(Iterator<Future<String>> iter  = results.iterator();iter.hasNext();){
				Future<String> f =iter.next();
				if(f.isDone()){
					System.out.println(f.get());
					iter.remove();
					
				}
			}
			if(results.size()==0){
				flag =false;
			}
			
		}
		
		System.out.println("执行完毕");
		 
		executor2.shutdownNow();
		 
		 */
		 
	

}
