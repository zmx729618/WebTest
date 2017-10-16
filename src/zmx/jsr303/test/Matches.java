package zmx.jsr303.test;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;  
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})  
@Retention(RetentionPolicy.RUNTIME)  
@Constraint(validatedBy = MatchesValidator.class)  
@Documented  
public @interface Matches {  
    String message() default "{constraint.not.matches}";  
    Class<?>[] groups() default {};  
    Class<? extends Payload>[] payload() default {};    
    String field();  
    String verifyField();  
}
