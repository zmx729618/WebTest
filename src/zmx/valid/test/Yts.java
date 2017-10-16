package zmx.valid.test;

import java.lang.annotation.*;


@Documented  
@Target({ElementType.TYPE,ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
public @interface Yts {
	
	   public enum YtsType{util,entity,service,model}  
	     
	   public YtsType classType() default YtsType.util; 


}
