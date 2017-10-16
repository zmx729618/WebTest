package advance.java.test;

public class Producer implements Runnable{
	
	private Bucket bucket;
	
	public Producer(Bucket bucket) {
		this.bucket = bucket;
	}

	@Override
	public void run() {
		while(true){
			bucket.put((int)(Math.random()*100));
		}
		
	}
	
	

}
