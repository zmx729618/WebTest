package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskWithLock extends Task implements Runnable{
    //声明显示锁
	public static final Lock lock = new ReentrantLock();
	@Override
	public void run() {
		try{
			lock.lock(); //锁定
			doSomething(); //
		}finally{
			lock.unlock(); //解锁
		}
		
	}

}
