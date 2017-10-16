package zmx.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class OSInfoUtil {
	
	private static String getIpAddress() throws UnknownHostException {  
		        InetAddress address = InetAddress.getLocalHost();  
		        return address.getHostAddress();  
	} 
	
	
	public static String getMACAddress(){  
		  
		        String address = "";  
		        String os = System.getProperty("os.name");  
		        String osUser=System.getProperty("user.name");  
		        if (os != null && os.startsWith("Windows")) {  
		  
		            try {  
		  
		                String command = "cmd.exe /c ipconfig /all";  
		                  
		                Process p = Runtime.getRuntime().exec(command);  
		  
		                BufferedReader br =new BufferedReader(new InputStreamReader(p.getInputStream()));  
		  
		                String line;  
		  String re="";
		               while ((line = br.readLine()) != null) {  
		            	     re+=line;
		                    if (line.indexOf("Physical Address") > 0) {  
		 
		                        int index = line.indexOf(":");  
		  
		                        index += 2;  
		  
		                        address = line.substring(index);  
		 
		                        break;  
		  
		                    }  
		  
		                }  
		  
		               br.close();  
		  System.out.println(re);
		               return address.trim();  
		  
		           }  
		 
		            catch (IOException e) {  
		            }  
		  
		        }  
		        return address;  
		  
		    }
	public static void main(String[] args) throws UnknownHostException {
		System.out.println(OSInfoUtil.getIpAddress());
		System.out.println(OSInfoUtil.getMACAddress());
	}



}
