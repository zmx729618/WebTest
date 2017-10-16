package spring.source.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringSourceTest {
	
/*   public static void main(String[] args) {
	   System.out.println("sadas");
   }*/

	private BeanFactory beanFactory;
	
	@Before
	public void init() throws IOException{
		Resource resource =  new ClassPathResource("applicationContext.xml");
		InputStream inputStream =  resource.getInputStream(); 
		
		byte[] bytes =  new byte[1024];
		int len = 0;
		ByteArrayOutputStream baos =  new  ByteArrayOutputStream();
		while((len = inputStream.read(bytes)) !=-1){
			baos.write(bytes, 0, len);		
		}		
		System.out.println(baos.toByteArray().length);
        System.out.println(new String(baos.toByteArray(), "utf-8"));
        
        
		beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		
		
		
	}
	
	
	@Test
	public void testSimplyLoad(){
		
		MyBeanTest myBeanTest = (MyBeanTest) beanFactory.getBean("myBeanTest");
		System.out.println(myBeanTest.getTestStr());
		Assert.assertEquals("testStr", myBeanTest.getTestStr());
	}
   
}
