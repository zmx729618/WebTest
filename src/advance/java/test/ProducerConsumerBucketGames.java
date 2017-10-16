package advance.java.test;

public class ProducerConsumerBucketGames {
	
	public static void main(String[] args) {
		Bucket bucket = new Bucket();
		
		new Thread(new Producer(bucket)).start();
		new Thread(new Consumer(bucket)).start();
	}

}
