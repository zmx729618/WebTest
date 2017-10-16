package zmx.intercepter.test;

public class SecondInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation invocation) {
		        System.out.println(2);  
		  
		        invocation.invoke();  
		  
		        System.out.println(-2); 

		
	}

}
