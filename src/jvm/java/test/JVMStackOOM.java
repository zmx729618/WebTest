package jvm.java.test;

public class JVMStackOOM {
	
	private void doNotStop(){
		while(true){
			
		}
	}
	
	public void stackLeakByThread(){
		while(true){
			
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					doNotStop();
				}
			});
			
			thread.start();
			
		}
	}
	
	public static void main(String[] args) {
		
		//JVMStackOOM jvmStackOOM = new JVMStackOOM();
		//jvmStackOOM.stackLeakByThread();
		
	}
	

}
