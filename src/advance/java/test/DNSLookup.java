package advance.java.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSLookup {
	
	public static void main(String[] args) {
		InetAddress[] inetHosts=null;
		System.out.println("List of Google servers");
		try {
			inetHosts = InetAddress.getAllByName("www.google.com");
			
			for(InetAddress ip : inetHosts){
				
				System.out.println(ip);
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
