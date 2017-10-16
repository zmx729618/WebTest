package jvm.java.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MethodAreaOOM {
    static class OOMObject{}
    
    //VM args : -XX:PermSize=5M -XX:MaxPermSize=10M
	public static void main(String[] args) {
		
		while(true){
			
			Enhancer enhancer =  new Enhancer();
			
			enhancer.setSuperclass(OOMObject.class);
			
			enhancer.setUseCache(false);
			
			enhancer.setCallback(new MethodInterceptor() {
				
				@Override
				public Object intercept(Object obj, Method method, Object[] args,
						MethodProxy proxy) throws Throwable {
					
					return proxy.invoke(obj, args);
				}
			});
			
			enhancer.create();
			
			
		}
		
	}

}
