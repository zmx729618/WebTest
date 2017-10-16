package zmx.dynamic.proxy.test;

import org.junit.Test;

public class MainTest {
	
    @Test  
    public void testJDKProxy() throws Throwable {  
        // 实例化目标对象  
        UserService userService = new UserServiceImpl();  
          
        // 实例化InvocationHandler  
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);  
          
        // 根据目标对象生成代理对象  
        UserService proxy = (UserService) invocationHandler.getProxy();  
          
        // 调用代理对象的方法  
        proxy.add();  
        proxy.delete();  
          
    } 
    
    
    @Test  
    public void testCglibProxy() throws Throwable {  
        // 实例化目标对象  
        UserService userService = new UserServiceImpl();  
          
        // 实例化InvocationHandler  
        MyCglibProxy cglib=new MyCglibProxy();
        
        // 根据目标对象生成代理对象  
        UserService proxy=(UserService)cglib.getInstance(userService);
       
          
        // 调用代理对象的方法  
        proxy.add();  
        boolean result = proxy.delete(); 
        System.out.println(result);
    }


}
