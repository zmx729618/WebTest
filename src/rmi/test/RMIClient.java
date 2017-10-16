package rmi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMIClient {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("rmi/test/rmiClient.xml");
		HelloRMIService helloRMIService =  applicationContext.getBean("myRMIClient",HelloRMIService.class);
		System.out.println(helloRMIService.getAdd(3, 4));
	}

}
