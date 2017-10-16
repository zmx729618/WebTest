package zmx.calss.loadorder;

public class B {

	E e = new E();
	static F f = new F();
	public String sb = getSb();
	static {
		System.out.println("执行B类的static块(B包含E类的成员变量,包含静态F类成员变量)");
		f.funcOfF();
	}
	{
		System.out.println("执行B实例的普通初始化块");
	}

	B() {
		System.out.println("执行B类的构造函数(B包含E类的成员变量,包含静态F类成员变量)");
		e.funcOfE();
	}

	public String getSb() {
		System.out.println("初始化B的实例成员变量sb");
		return "sb";
	}

}
