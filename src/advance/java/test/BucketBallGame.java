package advance.java.test;

import java.util.concurrent.locks.ReentrantLock;


public class BucketBallGame {
	
	private static boolean RIGHT_TO_LEFT = true;
	
	private int[] bucket = {1000,1000};
	
	ReentrantLock lock = new ReentrantLock();
		
	public static void main(String[] args) {
		new BucketBallGame().doTransfers();
	}
	
    private void doTransfers() {
    	
		for(int i=0; i<10; i++){ //开启十个线程			
			new Thread(new TransferThead(!RIGHT_TO_LEFT)).start();
			new Thread(new TransferThead(RIGHT_TO_LEFT)).start();			
		}
		
	}
    
    public synchronized void transfer(boolean direction,int numToTransfer){
    	
    	if(direction ==RIGHT_TO_LEFT){
    		
    		if((bucket[1] -numToTransfer)>=0){
    			
        		bucket[0] +=numToTransfer;
        		bucket[1] -=numToTransfer;
    		}
    		   		
    	}else{
    		
    		if((bucket[0] -numToTransfer)>=0){
    			
        		bucket[0] -=numToTransfer;
        		bucket[1] +=numToTransfer;
    		}

    		
    	}    	
    	System.out.println("Total="+(bucket[0]+ bucket[1]) +" bucket[0]=" +bucket[0]+" bucket[1]="+ bucket[1]);
    	
    }
    
    
    public  void transfer2(boolean direction,int numToTransfer){
    	lock.lock();
    	try {
			if(direction ==RIGHT_TO_LEFT){
				
				if((bucket[1] -numToTransfer)>=0){
					
					bucket[0] +=numToTransfer;
					bucket[1] -=numToTransfer;
				}
				   		
			}else{
				
				if((bucket[0] -numToTransfer)>=0){
					
					bucket[0] -=numToTransfer;
					bucket[1] +=numToTransfer;
				}
				
			}    	
			System.out.println("Total="+(bucket[0]+ bucket[1]) +" bucket[0]=" +bucket[0]+" bucket[1]="+ bucket[1]);
		
    	} finally{    		
			lock.unlock();			
		}
    	
    }
    
    
    

	private class TransferThead implements Runnable{
		
		private boolean direction;
		
		public TransferThead(boolean direction) {
			this.direction = direction;
		}
	
		@Override
		public void run() {
			
			for(int i=0; i<100; i++){
				
				transfer2(direction, (int)(Math.random()*500));
				
				try {					
					Thread.sleep((int)(Math.random()*100));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}									
			
		}
	
    }

}
