package zmx.concurrent.test;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest{
	
	private int num = 10;
    private ReentrantLock myLock = new ReentrantLock();
	public void writeNumMethod() {	
		myLock.lock();
		try{
			// 受保护的代码段
			int index =10;
			while(index > 0) {
				System.out.println(Thread.currentThread().getName() + " : "+ num);
				num-=10;
				long beginTime = System.currentTimeMillis();
				while(System.currentTimeMillis() - beginTime < 10){}
				num+=10;
				System.out.println(Thread.currentThread().getName() + " : "+ num);
				index--;
			}

	} finally {
			// 可以保证发生异常 锁可以得到释放 避免死锁的发生
			myLock.unlock();
		}
	}
	
	public void readNumMethod() {	
		myLock.lock();
		try{
			int index = 10;
			// 受保护的代码段
			while(index > 0) {
				System.out.println(Thread.currentThread().getName() + " : "+ num);
				index--;
			}

	} finally {
			// 可以保证发生异常 锁可以得到释放 避免死锁的发生
			myLock.unlock();
		}
	}
	
	
	public static void main(String [] args) {
		final ReentrantLockTest myLockTest = new ReentrantLockTest();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				myLockTest.writeNumMethod();
			}
		},"A");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				myLockTest.readNumMethod();
			}
		},"B");
		
		t1.start();
		t2.start();
	}
}
