package zmx.spring.aop.test;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//定义切面
@Aspect()
public class LoggerAspect {
	
	//定义切入点
	@Pointcut(value="execution(* zmx.spring.aop.test..*.*(..)) && args(param)", argNames = "param")  
	public void beforePointcut(String param) {}
	
	
	@Pointcut(value="execution(* zmx.spring.aop.test..*.*(..))")  
	public void afterPointcut(){}

	
	//定义通知
	
    //前置日志通知 
	@Before(value = "beforePointcut(param)", argNames = "param")  
	public void beforeAdvice(String param) {  
          System.out.println("===========before advice param:" + param);  
	} 
  
    //后置日志通知 
	@After(value = "afterPointcut()")
    public void afterAdvice() {  
        System.out.println("===========after advice param");  
    }


}
