package zmx.jvm.test;


public class StackOOM2 {

	/**
	 * @param args
	 */
	
	private int stackLength = 1;
	
	private void dontStop(){
		while(true){
			try{Thread.sleep(1000);}catch(Exception err){}
		}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread t = new Thread(new Runnable(){

				@Override
				public void run() {
					
					dontStop();
				}
				
			});
			t.start();
			stackLength++;
		}
	}
	
	public static void main(String[] args) throws Throwable{
		
		StackOOM2 oom = new StackOOM2();
		try{
			oom.stackLeakByThread();
		}catch(Throwable err){
			System.out.println("Stack length:" + oom.stackLength);
			throw err;
		}
		
	}

}

