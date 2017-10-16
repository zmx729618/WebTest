package dynamic.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Invoker implements InvocationHandler {
	
	/**
	 * 引用一个抽象类
	 */
    private AbstractClass abstractClass;
    
    
    
	public Invoker(AbstractClass abstractClass) {
		
		this.abstractClass = abstractClass;
		
	}


    /**
     * 处理方法
     */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		//调用之前做一些事情
		System.out.println("调用之前做一些事情");
		
		method.invoke(abstractClass, args);
		
		//调用之后做一些处理
		System.out.println("调用之后做一些事情");
		return null;
		
	}

}
