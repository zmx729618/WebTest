package zmx.spring.aop.test2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	
	@Test
	public void testCallMethodA(){
		
		    ApplicationContext ctx = new ClassPathXmlApplicationContext("zmx/spring/applicationContext.xml");
		    TestService testService = ctx.getBean("testService", TestService.class);  
		    testService.callMethodA();		    		   		   
		
	}

}
