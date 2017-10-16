package zmx.spring;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class LifeCycleTest {
	
	public static void main(String[] args) {
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("zmx/spring/applicationContext.xml"));
		factory.getBean("lifeBean");
		factory.getBean("lifeBean2");
		
	}

}
