package zmx.dynamic.proxy.test;

import java.lang.reflect.Proxy;

public class ProxyMain {
	
	public static void main(String[] args) {
		
		 CustomInvocationHandler customInvocationHandler = new CustomInvocationHandler(new HelloWorldImpl());
		
		 IHelloWorld proxy = (IHelloWorld) Proxy.newProxyInstance(ProxyMain.class.getClassLoader(), new Class[]{IHelloWorld.class},customInvocationHandler);
		 
		 proxy.sayHello("JIM");
	}

}
