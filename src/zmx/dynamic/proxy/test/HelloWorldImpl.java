package zmx.dynamic.proxy.test;

public class HelloWorldImpl implements IHelloWorld{

	@Override
	public void sayHello(String name) {
		System.out.println("hello,"+name);
		
	}

}
