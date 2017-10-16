package quartz.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextInitializer {
	public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
        
        System.out.println(ctx.getBean("myScheduler"));
        
        
        
        		
       
	}

}
