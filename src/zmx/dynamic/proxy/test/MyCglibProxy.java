package zmx.dynamic.proxy.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyCglibProxy implements MethodInterceptor{
	
	//目标对象
	private Object target; 
	
	
    /** 
     * 创建代理对象 
     *  
     * @param target 
     * @return 
     */  
    public Object getInstance(Object target) {  
        this.target = target;  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(this.target.getClass());  
        // 回调方法  
        enhancer.setCallback(this);  
        // 创建代理对象  
        return enhancer.create();  
    } 


	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		
		System.out.println("------------------before------------------");   
		Object result = proxy.invokeSuper(obj, args); 
	  //Object result = proxy.invoke(target, args);  
		System.out.println("-------------------after------------------");  
		return result;

		
		/*// 在目标对象的方法执行之前简单的打印一下  
        System.out.println("------------------before------------------");  
        // 执行目标对象的方法  
        Object result = method.invoke(target, args);  
        // 在目标对象的方法执行之后简单的打印一下  
        System.out.println("-------------------after------------------");  
        return result; */
        
	}

}
