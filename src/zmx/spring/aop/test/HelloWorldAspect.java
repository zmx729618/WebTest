package zmx.spring.aop.test;

public class HelloWorldAspect {
	
    //前置通知  
    public void beforeAdvice() {  
        System.out.println("===========before advice");  
    }  
    //后置通知  
    public void afterAdvice() {  
        System.out.println("===========after finally advice");  
    }


}
