package zmx.jsr303.test;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {
	
    private static Validator validator;  
  
    @BeforeClass  
    public static void setUp() {  
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();  
        validator = factory.getValidator();  
    } 
    
    @Test  
    public void testBuildDefaultValidatorFactory() {  
        assertNotNull(validator);  
    } 
    
    
    @Test  
    public void testPasswordEqualsConfirmPassword() {  
 
        User bean = new User();  
        bean.setPassword("110");  
        bean.setConfirmPassword("110");  
  
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(bean);  
        for (ConstraintViolation<User> constraintViolation : constraintViolations) {  
            System.out.println(constraintViolation.getMessage());  
        }  
  
        assertEquals("newPassword and confirmNewPassword should be the same.", 0, constraintViolations.size());  
    }




}
