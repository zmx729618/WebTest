package test;

import org.junit.Test;

public class DemoTest {
	
	    @Test
		public void testString() {
		    String str="Java";
		    StringBuffer sb= new StringBuffer("Java");
		    StringBuilder sbr= new StringBuilder("Java");
		    str.concat(" language");
		    sb.append(" language");
		    sbr.append(" language");

		    System.out.println(str); 
		    System.out.println(sb);
		    System.out.println(sbr);
		    
		    
		    }
	    
	    @Test
		public void testString2() {
	    	
	    	String str = "abc";
	    	String str1 = "abc";
	    	String str2 = new String("abc");

	    	System.out.println("str == str1   " + (str == str1));
	    	System.out.println("str == str2  " + (str == str2));
	    	
	    	// str2.intern() 常量池中有 就为常量池中的常量
	    	System.out.println("str == str2.intern() " + (str == str2.intern()));
		    
		   
	    }
	    
	    @Test
  		public void testString3() {
  	    	
  	    	String str = "abc";
  	    	String str2 = str;
            str2+="a";
  	    	System.out.println("str == str2  " + (str == str2));
  	    	
  	    	
  	    	StringBuffer str3 = new StringBuffer("abc");
  	    	
  	    	StringBuffer str4 = str3;
  	    	
  	    	str3.append("22");
  	    	System.out.println("str3 == str4  " + (str3 == str4));
  	    }
	


}
