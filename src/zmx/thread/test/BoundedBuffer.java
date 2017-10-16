package zmx.thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 一个处于多线程工作环境下的对象缓存区
 * 对象池
 * @author zhangwenchao
 *
 */
public class BoundedBuffer {

	final Lock lock = new ReentrantLock();// 锁对象
	final Condition notFull = lock.newCondition(); // 写线程条件
	final Condition notEmpty = lock.newCondition();// 读线程条件
	final Object[] items = new Object[100];// 对象缓存队列
	int putptr; /* 写索引 */
	int takeptr;/* 读索引 */
	int count;  /* 队列中存在的数据个数 */;

	/**
	 * 往缓冲池中加入对象--写入写索引对应的位置
	 * @param x
	 * @throws InterruptedException
	 */
	public void put(Object x) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length){// 如果队列满了
				notFull.await();// 阻塞写线程
			}	
			items[putptr] = x;// 赋值
			System.out.println("写入数据："+x+",写索引:"+ putptr);  //注意打印一定要放到锁内
			if (++putptr == items.length){
				putptr = 0;// 如果写索引写到队列的最后一个位置了，那么置为0
			}
				
			++count;// 个数++
			notEmpty.signal();// 唤醒读线程
		} finally {
			lock.unlock();
		}
	}
    
	/**
	 * 从缓冲池读出数据对象--从读索引对应的位置读出一个数据对象
	 * @return
	 * @throws InterruptedException
	 */
	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0){// 如果队列为空				
				notEmpty.await();// 阻塞读线程
			}	
			Object x = items[takeptr];// 取值
			
			System.out.println("读出数据："+x+",读索引:"+ takeptr);   //打印一定要放到锁内
			
			if (++takeptr == items.length){
				takeptr = 0;// 如果读索引读到队列的最后一个位置了，那么置为0
			}
				
			--count;// 个数--
			notFull.signal();// 唤醒写线程
			return x;
		} finally {
			lock.unlock();
		}
	}
	
	
	

	public static void main(String[] args) throws Exception {
		
	    final BoundedBuffer boundedBuffer = new BoundedBuffer();
	    
		for( int i=0; i<200;i++ ){//分别开启100个读/写线程
			final int data = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {	
						boundedBuffer.put(data);						
						Thread.sleep((int)(Math.random()*1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}).start();
			
			Thread.sleep(200);
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Integer obj = (Integer) boundedBuffer.take();
						Thread.sleep((int)(Math.random()*1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}).start();			
			
			
			

						
		}
		
	}

}
