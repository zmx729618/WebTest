package threadlocal.test;

public class SequenceNumber {
	
	//声明一个ThreadLocal对象，通过匿名内部类覆盖ThreadLocal的initialValue()的方法，指定初始值
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			
			return 0;
		}
	};   
	
	//获取下一个值
	public int getNextNum(){
		seqNum.set(seqNum.get()+1);
		return seqNum.get();
	}
	
	
	public static void main(String[] args) {
		//初始化一个SequenceNumber
		SequenceNumber sn = new SequenceNumber();
		
		//3个线程共享sn 各自产生序列号
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		
		t1.start();		
		t2.start();		
		t3.start();		
		
	}
	
	
	private static class TestClient extends Thread{
		
		private SequenceNumber sequenceNumber;
		
		public TestClient(SequenceNumber sequenceNumber) {
			this.sequenceNumber =sequenceNumber; 
		}

		@Override
		public void run(){
			
			for(int i=0;i<3;i++){
				
				System.out.println("thread["+Thread.currentThread().getName()+"]="+sequenceNumber.getNextNum());
				
			}
		}
		
		
	}
	

}
