package dynamic.proxy.test;

import java.lang.reflect.Proxy;

public class DynamicProxyClassTest {
	
	public static void main(String[] args) {
		
		//创建被代理对象
		AbstractClass abstractClass1 = new ClassA();
		
		AbstractClass abstractClass2 = new ClassB();
		
		//创建被代理类对象的处理对象
		Invoker invoker1 = new Invoker(abstractClass1);
		
		Invoker invoker2 = new Invoker(abstractClass2);
		
		//获得具体类的代理对象	
		AbstractClass proxy1 = (AbstractClass)Proxy.newProxyInstance(AbstractClass.class.getClassLoader(),new Class[]{ AbstractClass.class}, invoker1);
		
		AbstractClass proxy2 = (AbstractClass)Proxy.newProxyInstance(AbstractClass.class.getClassLoader(),new Class[]{ AbstractClass.class}, invoker2);
		
		//调用代理的处理方法
		proxy1.show();
		proxy1.view();
		
		proxy2.show();
		proxy2.view();
		
	}
	

	

}
