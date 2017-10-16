package rmi.http.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class RMIHttpClient {
	
	public static void main(String[] args) {
	//	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("httpRMIClient.xml");
	//	applicationContext.
		
		
		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();

		applicationContext.load("classpath:httpRMIClient.xml");

		applicationContext.refresh();
		
		HttpInvokerTest httpInvokerTest = applicationContext.getBean("httpRemoteService",HttpInvokerTest.class);
		System.out.println(httpInvokerTest.getTestPo(12));
	}

}
