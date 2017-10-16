package zmx.thread.pool;
/**
 * 使用线程池 需要一个永不退出的线程
 * @author zhangwenchao
 *
 */
public class PThread extends Thread{
	/**
	 * 线程池
	 */
	private ThreadPool pool;
	
	//任务
	private Runnable target;
	
	private boolean isShutDown = false;
	
	private boolean isIdle = false;

	//构造函数
	public PThread(ThreadPool pool, Runnable target,String name) {
		super(name);
		this.pool = pool;
		this.target = target;
	}
	
	public Runnable getTarget(){
		
		return target;
		
	}
	
	public boolean isIdle(){
		
		return isIdle;
	}

	@Override
	public void run() {
		//只要没有关闭，则一直不结束该线程
		while(!isShutDown){
			isIdle = false;
			if(target!=null){
				target.run();
			}
			
			//任务执行完毕
			isIdle = true;
			try{
				//任务结束后，不关闭线程，而是放入线程池中
				pool.repool(this);  
				synchronized (this) {
					wait();  //线程等待
				}	
				
			}catch (Exception e) {
				
			}
			
			//isIdle = false;		
		}		
	}
	
	//设置任务
	public synchronized void setTarget(Runnable newTarget){
		
		target = newTarget;		
		notifyAll();
		
	}
	
	//关闭线程
	public synchronized void shutDown(){
		isShutDown = true;
		notifyAll();
	}
	
	
	
	
	
	

}
