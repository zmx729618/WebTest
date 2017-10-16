package zmx.classloader.test;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;


public class MainTest {

	public static Method initAddMethod() {
		try {
			Method add = URLClassLoader.class.getDeclaredMethod("addURL",new Class[] { URL.class });
			add.setAccessible(true);
			return add;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws Exception{
		
	    /**
	     * 通过Jar包，加载class文件
	     */
		/*
		URLClassLoader  classloader = (URLClassLoader)ClassLoader.getSystemClassLoader();  
		String url = "file:"+ System.getProperty("user.dir") + "/WebRoot/WEB-INF/classes/zmx/classloader/test/test.jar";
		Method addURL = URLClassLoader.class.getDeclaredMethod("addURL",new Class[] { URL.class });  
		addURL.setAccessible(true);
	    URL classUrl = new URL(url);      
	    addURL.invoke(classloader, new Object[] { classUrl });
	    String className = "zmx.classloader.test.DynamicClass";  
	    Class<?> c = Class.forName(className);  
	    DynamicClass.Output();
	    */
	    
	    
	    
		// 热部署测试代码
		Thread t;
		t = new Thread(new Multirun());
		t.start();
	}
}
