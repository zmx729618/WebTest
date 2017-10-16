package test;

public class TestThread implements Runnable {

	@Override
	public void run() {
		int count=0;
		for(int i=0; i<100; i++){
			System.out.println(count++);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		

	}
	
	public static void main(String[] args) {
		TestThread  r = new TestThread();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}

}
