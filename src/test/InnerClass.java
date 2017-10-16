package test;

public class InnerClass {
	
	class Inner{
		 private void f(){
			 System.out.println("f");
		 }
	}
	
    public void ff(){
    	Inner in = new Inner();
    	in.f();
    }
	
	
	public static void main(String[] args) {
		
		
		
		
		 
	}

}
