package zmx.thread.pool;

public class Main {
	
	 static class MyThread implements Runnable{
		protected String name;
		
		public MyThread() {
			
		}
        public MyThread(String name) {
			this.name = name;
		}

		@Override
		public void run() {
		
			try {
				Thread.sleep(1000);
				System.out.println(name+"线程执行完毕");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		for(int i=0;i<1000;i++ ){
			ThreadPool.getInstance().start(new MyThread("testPool"+i));
		}
	}

}
