package zmx.dynamic.proxy.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.junit.Assert;
import org.junit.Test;

public class CglibMainTest {

	// 第一种写法,使用Enhancer静态create方法
	@Test
	public void testCGLIBProxy01() {
	    /*
	     * create有多种重载方式,此重载第一个参数为超类(本类)的类型,
	     * 若然需要动态代理的类没有实现接口,就需要填写第一个参数,
	     * 第二个参数为Class类型的数组,当动态代理的类有实现接口,
	     * 可以选择性填写第二个参数,否则为null
	     */
		RayTest test = (RayTest) Enhancer.create(RayTest.class, null,
				new MethodInterceptor() {
					@Override
					public Object intercept(Object arg0, Method arg1,
							Object[] arg2, MethodProxy arg3) throws Throwable {
						// 真实主题
						RayTest target = new RayTest();
						// 动态代理增加的logic
						String before = "before ";
						// 使用MethodProxy调用效率更高
						Object str = arg3.invoke(target, arg2);
						String after = " after";
						return before + str + after;
					}
				});
		System.out.println(test.execute());
		Assert.assertEquals("before execute after", test.execute());
	}
	
	// 第二种写法,创建Enhancer对象
	  @Test
	  public void testCGLIBProxy2() {
	    // 创建Enhancer类
	    Enhancer enhancer = new Enhancer();
	    // 当类没有实现接口而又需要动态代理,使用setSuperclass
	    enhancer.setSuperclass(RayTest.class);
	    // 当类实现了接口需要动态代理,使用setInterface
	    enhancer.setInterfaces(new Class[] {});
	    enhancer.setCallback(new MethodInterceptor() {
	      // 真实主题
	      RayTest test = new RayTest();

	      @Override
	      public Object intercept(Object arg0, Method method, Object[] args,
	          MethodProxy arg3) throws Throwable {

	        // 动态代理增加的logic
	        String before = "before ";
	        // 使用MethodProxy调用效率更高
	        Object str = arg3.invoke(test, args);
	        String after = " after";
	        return before + str + after;
	      }
	    });
	    System.out.println( ((RayTest)enhancer.create()).execute());
	    Assert.assertEquals("before execute after", ((RayTest)enhancer.create()).execute());

	  }
	  
	  
	  @Test
	  public void testCGLIBCallbackFilter() {
		  Enhancer enhancer = new Enhancer();
		  enhancer.setSuperclass(RayTest.class);

	      // 创建callback1
	      Callback callback1 = new MethodInterceptor() {
	    	  
	      // 真是主题类
	      RayTest test = new RayTest();

	      @Override
	      public Object intercept(Object obj, Method method, Object[] args,
	          MethodProxy proxy) throws Throwable {
	        String before = "callback1 before ";
	        Object str = proxy.invoke(test, args);
	        String after = " callback1 after";
	        return before + str + after;
	      }
	    };
	    // 创建callback2
	    Callback callback2 = new MethodInterceptor() {

	      // 真是主题类
	      RayTest test = new RayTest();

	      @Override
	      public Object intercept(Object obj, Method method, Object[] args,
	          MethodProxy proxy) throws Throwable {
	        String before = "callback2 before ";
	        Object str = proxy.invoke(test, args);
	        String after = " callback2 after";
	        return before + str + after;
	      }
	    };
	    // 使用setCallbacks设置多个Callback
	    enhancer.setCallbacks(new Callback[] { callback1, callback2 });
	    enhancer.setCallbackFilter(new CallbackFilter() {
	      static final int EXECUTE_METHOD = 0;
	      static final int OTHER_METHOD = 1;

	      /*
	       * accept需要返回一個int类型,
	       * 该int类型为上文中setCallbacks设置的多个
	       * Callback处理逻辑的数组的下标,上文中设置了两个Callback,
	       * 分别为callback1和callback2
	       */

	      @Override
	      public int accept(Method method) {
	        /*
	         * Method参数代表代理类的执行方法, 
	         * 以下logic为 判断执行方法名称是否为execute,
	         * 是则执行callback1,也就是数组下标为0的逻辑, 
	         * 否则执行Other逻辑
	         */
	        if ("execute".equals(method.getName()))
	          return EXECUTE_METHOD;
	        else
	          return OTHER_METHOD;
	      }
	    });
	    RayTest test = (RayTest) enhancer.create();
	    String executeResult = test.execute();
	    System.out.println(executeResult);
	    Assert.assertEquals("callback1 before execute callback1 after", executeResult);
	    
	    
	    String otherResult = test.action();
	    System.out.println(otherResult);
	    Assert.assertEquals("callback2 before action callback2 after", otherResult);
	  }
	


}
