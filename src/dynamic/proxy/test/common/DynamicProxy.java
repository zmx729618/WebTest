package dynamic.proxy.test.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler{
	//原始对象
	private Object originalObject;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("welcome");
		
		method.invoke(originalObject, args);
		
		System.out.println("Bye-bye");
		
		return null;
	}
	
	
	public Object creatProxyObject(Object object){
		
		this.originalObject = object;
		
		return Proxy.newProxyInstance(this.originalObject.getClass().getClassLoader(), this.originalObject.getClass().getInterfaces(), this);
	}
	
	
	
	
	public static void main(String[] args) {
		
		
	    Ihello ihelloProxy = (Ihello)new DynamicProxy().creatProxyObject(new Hello());
	    
	    ihelloProxy.sayHello();
	    
	    System.getProperties().put("sun.misc.ProxyGenerator.saveGenaratedFiles","true");
	}

}
