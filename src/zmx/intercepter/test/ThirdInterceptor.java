package zmx.intercepter.test;

public class ThirdInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation invocation) {
		        System.out.println(3);  
		  
		        invocation.invoke();  
		  
		        System.out.println(-3); 

		
	}

}
