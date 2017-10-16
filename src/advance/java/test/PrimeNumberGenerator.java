package advance.java.test;

public class PrimeNumberGenerator {
	
	public static void main(String[] args) {
		
		Thread thread =new Thread(new Runnable() {		
			@Override
			public void run() {
				long i=10001L;
				while(true){
					long j;
					for(j=2;j<i;j++){
						long n = i%j;						
						if(n==0){
							break;
						}						
					}
					if(i==j){
						System.out.print(" " + i);
						
						
					}					
					i++;
					
					try {					
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}								
			}
		});		
	//	thread.setDaemon(true);
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
		
	}

}
