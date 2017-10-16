package zmx.spring.aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	@Test
	public void testHelloWorld(){
		
		    ApplicationContext ctx = new ClassPathXmlApplicationContext("zmx/spring/applicationContext.xml");
		    IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);  
		    helloworldService.recordLog("日志");
		
	}
	


}
