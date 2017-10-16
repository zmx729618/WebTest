package zmx.clone.test;

public class User implements Cloneable{
	
	public String name;
	
	public int age;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	

}
