package jvm.java.test;

public class JVMStackSOF {
	
	private int stackLength = 1;
	
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	//JVM配置参数：-Xss10M
	public static void main(String[] args) {
		JVMStackSOF oom = new JVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Exception e) {
			System.out.println("stack length:"+oom.stackLength);
			e.printStackTrace();
		}
	} 
			
			

}
