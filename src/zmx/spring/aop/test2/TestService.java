package zmx.spring.aop.test2;

import org.springframework.aop.framework.AopContext;

public class TestService {
	
	public void callMethodA(){
		System.out.println("Method A  is  called");
		callMethodB(); //----------->AOP不能
		//((TestService) AopContext.currentProxy()).callMethodB();
		
		System.out.println("Method A  is  called  over");
	}
	
	
	public void callMethodB(){
		
		System.out.println("Method B  is  called");
	}

}
