package jvm.clazz.loading;
/**
 * 被动使用类字段
 * @author zhangwenchao
 *
 */
public class SuperClass {
	
	static{
		System.out.println("SuperClass init!");
	}
	
	public static int value = 123;
	
	

}
