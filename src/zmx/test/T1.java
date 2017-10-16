package zmx.test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Map;

public class T1 {
	public static void main(String[] args) throws UnknownHostException, SocketException, Exception {
		
		
		/*System.out.println(InetAddress.getLocalHost()); 
		
		Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		InetAddress ip = null;
		while (allNetInterfaces.hasMoreElements())
		{
		NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
		System.out.println(netInterface.getName());
		Enumeration addresses = netInterface.getInetAddresses();
		while (addresses.hasMoreElements())
		{
		ip = (InetAddress) addresses.nextElement();
		if (ip != null && ip instanceof Inet4Address)
		{
		System.out.println("本机的IP = " + ip.getHostAddress());
		} 
		}
		} 
		
		
		*/
		/*String osUser=System.getProperty("user.name");
		System.out.println(osUser);*/
		
		/*//获取JVM系统参数
		for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) { 
            System.out.println(entry.getKey()+"\t"+entry.getValue()); 
        }*/
		
        T1 t = new T1(); 
        Class clazz = t.getClass(); 
        ClassLoader loader = clazz.getClassLoader(); 
        System.out.println(loader); 
        System.out.println(loader.getParent()); 
        System.out.println(loader.getParent().getParent()); 
		
		

        //使用ClassLoader.loadClass()来加载类，不会执行初始化块 
        Class c1 =loader.loadClass("zmx.test.T2"); 
        System.out.println(c1+" :"+c1.getClassLoader());
        //使用Class.forName()来加载类，默认会执行初始化块 
//      Class.forName("zmx.test.T2"); 
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块 
//      Class.forName("zmx.test.T2", false, loader); 
		
          
          URL url = new URL("file:\\D:\\projects\\testWeb\\src"); 
          ClassLoader myloader = new URLClassLoader(new URL[]{url}); 
          System.out.println(myloader);
          Class c = myloader.loadClass("zmx.test.T2");
          System.out.println(c+" :"+c.getClassLoader());
          System.out.println("----------"); 
          T2 t2 = (T2) c.newInstance(); 
		
	}
	
	

}
