package zmx.intercepter.test;

public class FirstInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation invocation) {
		
		        System.out.println(1);  
		  
		        invocation.invoke();  
		  
		        System.out.println(-1); 

		
	}

}
