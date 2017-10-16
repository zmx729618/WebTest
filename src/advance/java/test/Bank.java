package advance.java.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Bank {
	
	private final static int COUNT = 100;
	
	private final static Semaphore semaphore = new Semaphore(4, true);
	
	public static void main(String[] args) {
		
		for(int i=0; i<COUNT; i++){
			
			final int count=i;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						if(semaphore.tryAcquire(100,TimeUnit.MILLISECONDS)){
							
							try {
								Teller.getService(count);
							} finally {
								semaphore.release();
							}
							
						}else{
							System.out.println("等待超时离开："+count);
						}
					} catch (InterruptedException e) {													
						e.printStackTrace();
					}
					
				}
			}).start();
			
		}
		
	}

}
