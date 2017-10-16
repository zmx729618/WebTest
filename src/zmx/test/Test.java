package zmx.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.exec.ExecuteStreamHandler;

public class Test <T> extends ClassA<T>{  
	
	
	public static void main(String args[]) throws Exception{  
		  
		    System.out.println("======getSuperclass======:");    
		    System.out.println(Test.class.getSuperclass().getName());            
		    System.out.println("======getGenericSuperclass======:");    
		    Type t = Test.class.getGenericSuperclass();    
		    System.out.println(t);    
		    if (ParameterizedType.class.isAssignableFrom(t.getClass())) {   
			      System.out.print("----------->getActualTypeArguments:");    
			      for (Type t1:((ParameterizedType)t).getActualTypeArguments()) {    
			        System.out.print(t1 + ",");    
			      }    
			      System.out.println();    
	        }  
		    
		    ExecutorService es  = Executors.newFixedThreadPool(3); 
		    
		    CompletionService cs = new ExecutorCompletionService<>(es);
		    
	}

}
