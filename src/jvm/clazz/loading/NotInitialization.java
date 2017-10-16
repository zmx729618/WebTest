package jvm.clazz.loading;

/**
 * 
 * @author zhangwenchao
 *
 */
public class NotInitialization {
	
	public static void main(String[] args) {
		
		System.out.println(SubClass.value);  //  通过子类引用父类的静态字段，只有父类初始化，不会导致子类初始化
		
		SuperClass[] sca = new SuperClass[10]; // 通过数组定义来引用类，不会导致此类初始化。
		
		System.out.println(ConstClass.HELLOWORD); // 常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类
		System.out.println(ConstClass.number);    // 因此不会触发定义常量的类的初始化   
		                                 
		
		
	
	}

}
