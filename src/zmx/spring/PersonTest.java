package zmx.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
	
	public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("zmx/spring/applicationContext.xml");
        Person person = appContext.getBean(Person.class);
        for (Person.Hand hand : person.getHands()) {
        	System.out.println("hand strength is " + hand.getStrength());
        }
	}

}
