package concurrent.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock extends Thread {
	
	private ReentrantLock lock;
	
	private int id;

	public MyReentrantLock( int id, ReentrantLock lock) {
		this.lock = lock;
		this.id = id;
	}

	@Override
	public void run() {
		print(id);
      
	}
	
	
    public void print(int str) {  
        try {  
            lock.lock();  
            System.out.println(str + "获得");  
            Thread.sleep((int) (Math.random() * 1000));  
        }catch (Exception e) {  
            e.printStackTrace();  
        }finally {  
            System.out.println(str + "释放");  
            lock.unlock();  
        }  
    }
    
    
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();  
        ReentrantLock lock = new ReentrantLock();  
        for (int i = 0; i < 10; i++) {  
            service.submit(new MyReentrantLock(i, lock));  
        }  
        service.shutdown();  
    }
    	
	
	

}
