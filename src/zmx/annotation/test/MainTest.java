package zmx.annotation.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@AnnoTest(age=19, value = "class",name="MainTest")
public class MainTest {


    @AnnoTest(name="world", value = "method")
	public static void method() {
	    System.out.println("Annotation AnnoTest has been invoke");
	}
    
    
    public static void main(String[] args) {
        
        try {
	        for (Method method :MainTest.class.getMethods()) {
	            // checks if MethodInfo annotation is present for the method
	            if (method.isAnnotationPresent(AnnoTest.class)) {
	                try {
	                    // iterates all the annotations available in the method
	                    for (Annotation anno : method.getDeclaredAnnotations()) {
	                        System.out.println("Annotation in Method"+ method + " : " + anno);
	                    }
	
	     
	                } catch (Throwable ex) {
	                        ex.printStackTrace();
	                }
	            }
             }
        } catch (SecurityException  e) {
                e.printStackTrace();
        }
}
	

    
	 

	
}
