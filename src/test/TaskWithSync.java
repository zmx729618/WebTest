package test;

public class TaskWithSync extends Task implements Runnable{
    private static final String str = "A";
	@Override
	public void run() {
		synchronized (str) {
			doSomething();
		}
		
	}

}
