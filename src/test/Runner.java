package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/**
 * 等待所有子线程都执行完毕，在主线进行操作。
 * @author zhangwenchao
 *
 */
public class Runner implements Callable<Integer>{
	
	private CountDownLatch begin;
	
	private CountDownLatch end;
	
	
	public Runner(CountDownLatch begin,CountDownLatch end) {
		this.begin = begin;
		this.end = end;
	}

	@Override
	public Integer call() throws Exception {
		
		//跑步成绩
		int score = new Random().nextInt(20);
		
		begin.await(); //使当前线程在锁存器倒计数至零之前一直等待。。。。线程等待
		
		System.out.println("跑步中。。。");
		TimeUnit.SECONDS.sleep(score);
		System.out.println("跑步结束,用时:"+score+"s");
		end.countDown();   //计数器减1;
		return score;
	}
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//参加赛跑人数
		int num = 8;
		
		CountDownLatch begin = new CountDownLatch(1);  
		
		CountDownLatch end = new  CountDownLatch(num); 
		
		ExecutorService es = Executors.newFixedThreadPool(num);
		
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		
		for(int i=0; i<num; i++){
			
			futures.add(es.submit(new Runner(begin, end)));
			
		}
		
		begin.countDown();  //所有线程开始运行，跑步开始
		
		end.await();  //主线程等待，所有跑步者完成比赛
		
		int count=0;
		for(Future<Integer> f : futures){
			if(f !=null)
			count += f.get();
		}
		
		System.out.println("平均分为："+ count/num);
		System.exit(0);
	}

}
