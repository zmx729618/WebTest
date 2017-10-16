package zmx.thread.pool;

import java.util.List;
import java.util.Vector;

public class ThreadPool {
	
	private static ThreadPool instance=null;
	
	//空闲的线程总数
	private List<PThread> idleThreads;
	
	//已有的线程总数
	private int threadCounter;
	
	private boolean isShutDown = false;
	
	private ThreadPool(){
		this.idleThreads = new Vector(5);
		threadCounter = 0;
	}
	
	public synchronized static ThreadPool getInstance(){
		if(instance ==null){
			instance = new ThreadPool();
		}
		return instance;
	}
	
	//获取线程总数
	public int getCreatedThreadsCount(){
		return threadCounter;
	}

    /**
     * 将线程放入池中
     * @param pThread
     */
	protected synchronized void repool(PThread pThread) {
		
		if(!isShutDown){
			idleThreads.add(pThread);
		}else{
			pThread.shutDown();
		}
		
		
	}
	
	/**
	 * 停止池中所有线程
	 */
	public synchronized void shutDown(){
		
		isShutDown = true;
		for(int threadIndex = 0; threadIndex < idleThreads.size(); threadIndex++){
			PThread idleThread = idleThreads.get(threadIndex);
			idleThread.shutDown();
		}
		
	}
	
	public synchronized void start(Runnable target){
		
		PThread thread = null;
		if(idleThreads.size() > 0){//如果有空闲线程，则直接使用
			
			int lastIndex =  idleThreads.size() - 1;
			thread = (PThread)idleThreads.get(lastIndex);
			idleThreads.remove(lastIndex);
			thread.setTarget(target);
			
		}else{//没有空闲线程，则创建新线程
			
			
			threadCounter++;
			
			thread = new PThread(this, target, "PThread #"+threadCounter) ;
			
			thread.start();
			
		}
		
	}
	
	
	

}
