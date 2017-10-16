package zmx.clone.test;

import org.junit.Assert;
import org.junit.Test;


public class MainTest {
	@Test
	public void testClone() throws Exception{
		
		Person person = new Person();
		person.setName("user");
		person.setAge(20);
		
		Account account = new Account();
		
		account.setPerson(person);
		account.setBalance(10000);
		
		Account copy =  (Account)account.clone();
		
		//balance因为是基本类型，所以copy和原型是相等且独立的
		Assert.assertEquals(copy.getBalance(), account.getBalance());
		copy.setBalance(20000);
		
		//改变copy不影响原型
		Assert.assertTrue(copy.getBalance() != account.getBalance()); 
		
		//user因为是引用类型，所以copy和原型的引用是同一的。  
		Assert.assertTrue(copy.getPerson() == account.getPerson());  

		copy.getPerson().setName("newName");  

		// 改变的是同一个东西，原形也跟着改变了。  
		Assert.assertEquals("newName", account.getPerson().getName());

		
	}
	
	
	@Test
	public void testClone2() throws Exception{
		
		// user.  
		User user = new User();  
		user.name = "user";  
		user.age = 20;  
		// copy  
		User copy = (User) user.clone();  
		// age因为是primitive，所以copy和原型是相等且独立的。  
		Assert.assertEquals(copy.age, user.age);  
		copy.age = 30;  
		// 改变copy不影响原型。  
		Assert.assertTrue(copy.age != user.age); 		
		// name因为是引用类型，所以copy和原型的引用是同一的。  
		Assert.assertTrue(copy.name == user.name);  
		System.out.println(copy.name == user.name);
		// String为不可变类。没有办法可以通过对copy.name的字符串的操作改变这个字符串。  
		// 改变引用新的对象不会影响原型。  
		copy.name = "newname";  
		Assert.assertEquals("newname", copy.name);  
		Assert.assertEquals("user", user.name); 
		System.out.println(copy.name +" "+user.name );

		
	}
	
	
	
	


}
