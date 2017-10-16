package zmx.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class T8 {
	
	public static String getMACAddress(){  
		  
        String address = "";  		
        String encoding = System.getProperty("file.encoding");  
        System.out.println(encoding);
        String os = System.getProperty("os.name");  
        String osUser=System.getProperty("user.name");  
        if (os != null && os.startsWith("Windows")) {  	
            try{    
              //String command = "cmd.exe /c ipconfig /all";     
            	String command = "ipconfig -all";                 	
                Process p = Runtime.getRuntime().exec(command);    
                BufferedReader br =new BufferedReader(new InputStreamReader(p.getInputStream()));    
                String line;    
                while ((line = br.readLine()) != null) { 
                	System.out.println(line);
                    if (line.indexOf("物理地址") > 0) {    
                        int index = line.indexOf(":"); 
                        index += 2;    
                        address = line.substring(index);    
                        break;    
                    }    
                }    
                br.close();    
                return address.trim();    
            }catch (IOException e) {  
            }    
        }  
        return address;  		  
    }
	
	
  
	public static String bytes2hex01(byte[] bytes){  
        BigInteger bigInteger = new BigInteger(1, bytes);  
        //System.out.println(">>>>>>>>>>>>>>>>>>"+bigInteger);
        return bigInteger.toString(16);  
	} 

		
	public static String bytes2hex02(byte[] bytes){  
        StringBuilder sb = new StringBuilder();  
        String tmp = null;  
        for (byte b : bytes)  
        {  
          //将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制  
          //System.out.println(">>>>>>>>>>>>>>>"+(0xFF & b));
        	tmp = Integer.toHexString(0xFF & b);  
          //System.out.println("-----------"+tmp);
            if (tmp.length() == 1)// 每个字节8为，转为16进制标志，2个16进制位  
            {  
                tmp = "0" + tmp;  
            }  
            sb.append(tmp);  
        }  	   
        return sb.toString();     
	} 
	
    public static String bytes2hex03(byte[] bytes){    	
        final String HEX = "0123456789abcdef";  
        StringBuilder sb = new StringBuilder(bytes.length * 2);  
        for(byte b : bytes){  
            // 取出这个字节的高4位，然后与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数  
            sb.append(HEX.charAt((b >> 4) & 0x0f));  
            // 取出这个字节的低位，与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数  
            sb.append(HEX.charAt(b & 0x0f));  
        }  	
        return sb.toString();  
	} 
	
	
	public static void main(String[] args) {
	  //System.out.println(T8.getMACAddress());		
		String str="abcdefg中国人";
		byte[] digest = null;  
        try{  
            MessageDigest md = MessageDigest.getInstance("md5");  
            digest = md.digest(str.getBytes()); 
            /*
            for(byte b : digest){
            	System.out.println(b);
            }
            */             
            System.out.println(bytes2hex01(digest));             
            System.out.println(bytes2hex02(digest)); 
            System.out.println(bytes2hex03(digest));            
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }

	}
	
	
	
	
	


}
