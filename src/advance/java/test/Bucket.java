package advance.java.test;

public class Bucket {
	
	private int packOfBalls;
	private boolean available = false;
	
	public synchronized int get(){
		
		if(available){			
			System.out.println("Consumer Got" + packOfBalls);			
			available =false;
			notify();
            return packOfBalls;
		}else{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
	}
	
	public synchronized void put(int packOfBalls){
		
		if(available){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}				
		}else{
			
			this.packOfBalls = packOfBalls;
			available =true;
			System.out.println("producer put" + packOfBalls);
			
			notify();
			
		}
		
	}

}
