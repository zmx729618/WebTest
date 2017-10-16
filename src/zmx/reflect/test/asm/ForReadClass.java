package zmx.reflect.test.asm;

public class ForReadClass {
	
	    final int init = 110; 
	    private final Integer intField = 120; 
	    public final String stringField = "Public Final Strng Value"; 
	    public static String commStr = "Common String value"; 
	    String str = "Just a string value"; 
	    final double d = 1.1; 
	    final Double D = 1.2; 
	     
	    public ForReadClass(){ 
	    	
	    } 
	     
	    public void methodA(){ 
	        System.out.println(intField); 
	    } 
	    
	    
	    public static void main(String[] args) {
	    	ForReadClass class1 = new  ForReadClass();
			System.out.println(class1.d);
			System.out.println(class1.D);
			System.out.println(class1.str);
			System.out.println(class1.stringField);
			System.out.println(class1.init);
			System.out.println(class1.intField);
			System.out.println(ForReadClass.commStr);
		}


}
