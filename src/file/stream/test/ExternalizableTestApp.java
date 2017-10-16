package file.stream.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class ExternalizableTestApp {
	
	
	public static void main(String[] args) {
		

	   try {
	       Customer customer =  new Customer(1,"1234-5678-9876");
	       
	       System.out.println("Before saving Object: ID:"+customer.getId() +" CC:"+customer.getCreditCard());
				   
		   ObjectOutputStream objectOutputStream =  new  ObjectOutputStream(new  FileOutputStream("custom.dat"));
	       
		   objectOutputStream.writeObject(customer);
		   
		   objectOutputStream.close();
		   
		   ObjectInputStream objectInputStream =  new  ObjectInputStream( new  FileInputStream("custom.dat"));
		  
		   customer = (Customer)objectInputStream.readObject();
		   
		   System.out.println("After saving Object: ID:"+customer.getId() +" CC:"+customer.getCreditCard());
		   
		   objectInputStream.close();
		   
	   }catch (Exception e) {
		
		   e.printStackTrace();
	   }  
		
	}
	


}
