package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SubjectHandler implements InvocationHandler {
	private Subject subject ;
	
	public SubjectHandler(Subject subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		Object  obj = method.invoke(subject, args);
		after();
		return obj;
	}

	private void after() {
		
		System.out.println("do something before...");
	}

	private void before() {
		System.out.println("do something after...");
		
	}
	
	
	public static void main(String[] args) {
		
		Subject subject = new  SubjectImpl();
		
		Subject subjectProxy = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), subject.getClass().getInterfaces(), new SubjectHandler(subject));
		
		subjectProxy.doSomething();
		subjectProxy.doAnything();
	}
	
	

}
