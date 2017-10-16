package base64.test;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class DemoTest {
	
	@Test
	public void testBase64Encode(){
		
        String str = "Hello World";  
        try{  
            byte[] encodeBase64 = Base64.encodeBase64(str.getBytes("UTF-8"));  
            System.out.println("RESULT: " + new String(encodeBase64));  
        } catch(UnsupportedEncodingException e){  
            e.printStackTrace();  
        } 
	}

	
	@Test
	public void testBase64Decode(){
		
        String str = "SGVsbG8gV29ybGQ=";  
        try{  
            byte[] decodeBase64 = Base64.decodeBase64(str.getBytes("UTF-8"));  
            System.out.println("RESULT: " + new String(decodeBase64));  
        } catch(UnsupportedEncodingException e){  
            e.printStackTrace();  
        } 
	}

}
