package zmx.serialization.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIO {
	
	public static void main(String[] args) {
		
		GuestLoggingInfo logInfo = new GuestLoggingInfo("MIKE", "MECHANICS");   
		GuestLoggingInfo.size = 100;
		System.out.println(logInfo.toString());   
		try  
		{   
		   ObjectOutputStream o = new ObjectOutputStream( new FileOutputStream("logInfo.out"));   
		   o.writeObject(logInfo);   //写入数据
		   o.close();   
		}catch(Exception e) {
		   e.printStackTrace();
		}
		  
		try  
		{   
		   ObjectInputStream in =new ObjectInputStream( new FileInputStream("logInfo.out"));   
		   GuestLoggingInfo logInfo2 = (GuestLoggingInfo)in.readObject();   //读取数据
		   System.out.println(logInfo2.toString()); 
		   in.close();
		}catch(Exception e) {  
			e.printStackTrace();
		}
		
	}

}
