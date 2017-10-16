package zmx.util;

import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
/**
 * 从类路径下获取资源文件并进行读写
 * @author zhangwenchao
 *
 */
public class PropertyUtil {

	private static Properties prop = null;

	/**
	 * 初始化Properties实例
	 * @param propertyName
	 * @throws Exception
	 */
	public synchronized static void initProperty(String propertyName) throws Exception {
		if (prop == null) {
			prop = new Properties();
			InputStream inputstream = null;
			ClassLoader cl = PropertyUtil.class.getClassLoader(); 
			System.out.println(cl);
			if  (cl !=  null ) {        
				inputstream = cl.getResourceAsStream( propertyName );        
			}  else {        
				inputstream = ClassLoader.getSystemResourceAsStream(propertyName );        
			}   

			if (inputstream == null) {
				throw new Exception("inputstream " + propertyName+ " open null");
			}
			prop.load(inputstream);
			inputstream.close();
			inputstream = null;
		}
	}
    /**
     * 读取数据
     * @param propertyName
     * @param key
     * @return
     */
	public static String getValueByKey(String propertyName, String key) {
		String result = "";
		try {
			initProperty(propertyName);
			result = prop.getProperty(key);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static String getValueByKey2(String propertyBaseName, String key) {
		Locale locale = Locale.getDefault();    
		ResourceBundle localResource = ResourceBundle.getBundle(propertyBaseName, locale);    
		String value = localResource.getString(key);    
		return value;
	}
	
	
	

	public static void main(String[] s) {
		
		try {
			//得到当前类class文件的URI目录：file:/D:/projects/testWeb/WebRoot/WEB-INF/classes/zmx/util/
			System.out.println(PropertyUtil.class.getResource(""));
			
			//得到当前的classpath的绝对URI路径:file:/D:/projects/testWeb/WebRoot/WEB-INF/classes/
			System.out.println(PropertyUtil.class.getResource("/"));
			
			//得到当前的ClassPath的绝对URI路径：file:/D:/projects/testWeb/WebRoot/WEB-INF/classes/
			System.out.println(PropertyUtil.class.getClassLoader().getResource(""));
			
			//得到当前的ClassPath的绝对URI路径：file:/D:/projects/testWeb/WebRoot/WEB-INF/classes/
			System.out.println(ClassLoader.getSystemResource(""));
			
			//得到当前的ClassPath的绝对URI路径：file:/D:/projects/testWeb/WebRoot/WEB-INF/classes/
			System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
			
			
			
			
			
			System.out.println(PropertyUtil.getValueByKey("config_zh_CN.properties","host"));
			System.out.println(PropertyUtil.getValueByKey2("config","host"));
			
			
			

			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
}
