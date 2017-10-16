package jvm.clazz.view;

public class Person implements Cloneable{
	
	private String name;
	
	private int age;
	
	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Person p = new  Person();
		p.age=2;
		p.name="zhangsan";
		p.sex="male";
		
		
		Person p2 = p;  //指向同一个对象；
		p2.age = 3;
		p2.setSex("famale");
		
		System.out.println(p.age);
		System.out.println(p.getSex());
		
		
		Person p3 = (Person) p.clone();
		p3.age=5;
		System.out.println(p3.age);
		System.out.println(p.age);
		
		
	}

}
