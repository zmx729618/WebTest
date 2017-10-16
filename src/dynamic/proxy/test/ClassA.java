package dynamic.proxy.test;

public class ClassA implements AbstractClass {

	@Override
	public void show() {
		
		System.out.println("我是A类----show()");

	}
	
	@Override
	public void view() {
		
		System.out.println("我是A类---view()");

	}

}
