package zmx.spring.aop.test2;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect {
	
	@AfterReturning("execution(* zmx.spring.aop.test2.TestService.callMethodB(..))")  
	public void after() {  
	System.out.println("after call and do something.");
	}

}
