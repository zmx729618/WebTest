package jvm.clazz.loading;

public class ConstClass {
	
	static{
		
		System.out.println("ConstClass init!"); 
		
	}
	
	public static final String HELLOWORD ="hello world";
	public static final int number =2;

}
