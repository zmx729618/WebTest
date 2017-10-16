package advance.java.test;

public class Consumer implements Runnable{
	
	private Bucket bucket;
	
	public Consumer(Bucket bucket) {
		this.bucket = bucket;
	}

	@Override
	public void run() {
		
		while(true){
			bucket.get();
		}
	}

}
