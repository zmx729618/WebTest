package jvm.clazz.loading;

import java.io.IOException;
import java.io.InputStream;
/**
 * 比较两个类是否相等，只有在同一个类加载器器加载的情况下才有意义。
 * 即使两个类来源同一个Class文件，只要加载它们的类加载器不同，那这两个类就必定不相等。
 * @author zhangwenchao
 *
 */
public class ClassLoaderTest {
	
	public static void main(String[] args) throws Exception {
		
		
		ClassLoader myClassLoader = new ClassLoader() {

			@Override
			public Class<?> loadClass(String name)throws ClassNotFoundException {
				
				try{
					
					String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if(is == null){
						return super.loadClass(name);		
					}
					
					byte[] b =  new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
					
				}catch(IOException e){
					throw new ClassNotFoundException();
				}
			}
			
		};
		
		Object obj = myClassLoader.loadClass("jvm.clazz.loading.ClassLoaderTest").newInstance();
		
		System.out.println(obj.getClass());
		
		System.out.println(obj instanceof jvm.clazz.loading.ClassLoaderTest);
		
		System.out.println(obj.getClass().getClassLoader().getClass());  //我们自定义的类加载器加载的类，没有使用委托机制
		
		System.out.println(jvm.clazz.loading.ClassLoaderTest.class.getClassLoader().getClass());  //系统应用程序提供的类加载器，使用委托机制
		
		//
		
	}

}
