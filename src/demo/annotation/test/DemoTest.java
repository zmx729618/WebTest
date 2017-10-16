package demo.annotation.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@AnnotationDemo(name="company",value="nericta")
public class DemoTest{
	@AnnotationDemo(name="company",value="nericta")
	public void testMethod(){
		System.out.println("ffff");
	}
	
	public static void main(String[] args) {
		DemoTest demoTestObj = new DemoTest(); 
		
		Class clazz =  demoTestObj.getClass();
		
		Annotation annotation = clazz.getAnnotation(AnnotationDemo.class);
		
		System.out.println("Class:"+clazz.getName());
        if(clazz.isAnnotationPresent(AnnotationDemo.class)){
        	System.out.println(annotation);
        }
		
        
        Method[] methods = clazz.getMethods();
        for(Method m : methods){
        	
            if(m.isAnnotationPresent(AnnotationDemo.class)){
            	System.out.println("方法："+m.getName()+" 注解 :  "+annotation);
            }
        	
        }
		
		demoTestObj.testMethod();
	}

}
