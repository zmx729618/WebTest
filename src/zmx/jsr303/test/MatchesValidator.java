package zmx.jsr303.test;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class MatchesValidator implements ConstraintValidator<Matches,Object>{
	  private String field;  
	  private String verifyField; 

	@Override
	public void initialize(Matches matches) {
        this.field = matches.field();  
        this.verifyField = matches.verifyField(); 

		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {  
            String fieldValue= BeanUtils.getProperty(value,field);  
            String verifyFieldValue = BeanUtils.getProperty(value,verifyField);  
            boolean valid = (fieldValue == null) && (verifyFieldValue == null);  
            if(valid){  //如果都为空
                return true;  
            }  
  
            boolean match = (fieldValue!=null) && fieldValue.equals(verifyFieldValue);  
            if(!match){ //如果不相等 
                String messageTemplate = context.getDefaultConstraintMessageTemplate();  
                context.disableDefaultConstraintViolation();  
                context.buildConstraintViolationWithTemplate(messageTemplate)  
                        .addNode(verifyField)  
                        .addConstraintViolation();  
            }  
            return match;  
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
        } catch (InvocationTargetException e) {  
            e.printStackTrace();  
        } catch (NoSuchMethodException e) {  
            e.printStackTrace();  
        }  
        return true;

	}  


}
