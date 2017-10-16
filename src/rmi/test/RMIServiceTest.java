package rmi.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMIServiceTest {
	
	public static void main(String[] args) {
		
		new ClassPathXmlApplicationContext("rmi/test/rmiServer.xml");
		
	}

}
