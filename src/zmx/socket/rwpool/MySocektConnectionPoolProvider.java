package zmx.socket.rwpool;



import java.util.*;
import java.net.*;
import java.io.IOException; 

/**
 * socket连接池
 * @author zhangwenchao
 *
 */

public class MySocektConnectionPoolProvider implements ConnectionProvider { 

  private static ConnectionProvider provider = null;
  private static Object object_lock = new Object();
  private static Object[] object_lock_list = new Object[Integer.parseInt(ResourceBundle.getBundle("prop").getString("max_size"))];
  private String ip;
  private String port; 
  
  /**
   * 默认的最大连接数
   */
  private int max_size = 20; 
  

  /**
   * 默认的最小连接数 
   */
  private int min_size = 5; 
  

  /**
   * Socket connection
   */
  private SocketAdapter[] socketpool = null; 
  

  /**
   * 构造对象的时候初始化连接池
   * @throws UnknownHostException
   * @throws IOException
   */
  private MySocektConnectionPoolProvider() throws UnknownHostException,
      IOException {
	ResourceBundle  res =ResourceBundle.getBundle("prop");
    ip =res.getString(SERVER_IP);
    port = res.getString(SERVER_PORT);
    String max_size_s = res.getString(MAX_SIZE);
    String min_size_s = res.getString(MIN_SIZE);
    if (max_size_s != null) {
      max_size = Integer.parseInt(max_size_s);
    }
    if (min_size_s != null) {
      min_size = Integer.parseInt(min_size_s);
    } 

    init(); //构造对象的时候初始化连接池

  } 

  /**
   * 判断是否已经池化
   * @return boolean 如果池化返回ture,反之返回false
   */
  public boolean isPooled() {
    if (socketpool != null) {
      return true;
    }
    else return false;
  } 

  /**
   *返回一个连接
   * @return a Connection object.
   * @throws IOException 
   */
  public SocketAdapter getConnection()  {	
	
	  SocketAdapter s = null;
	  //System.out.println("loop");
      for (int i = 0; i < socketpool.length; i++) {
    	//System.out.println("loop detail i="+i);
        if (socketpool[i] != null) {//如果连接不为空            
    	    if(!socketpool[i].isFree()){//判断改连接是否空闲，如果不为空闲连接，继续循环
    		     continue;
        	}else{//如果为空闲的连接，返回一个空闲连接
        		 synchronized (object_lock_list[i]){ //锁住
        		    if (socketpool[i].isFree()) {
	       			    s =  socketpool[i];			 
	       			    // System.out.println(i+" socket isConnected()="+s.isConnected()+" binding"+s.isBound());	       			    
		       			 try {
		     	        	System.out.println("new socket"+i);
		     	            s = socketpool[i] = new SocketAdapter(ip, Integer.parseInt(port));
		     	           socketpool[i].setBusy(); 
		     	            return s;
		     	        }catch (Exception e) {
		     	        	return null;
		     	        }	       				    	       			 
        		    }else{
        			   continue;
        		    }
        		}
        	}
    	 
        
      }else { //如果连接为空，证明超过最小连接数，重新生成连接
	        try {
	        	System.out.println("new socket"+i);
	            s = socketpool[i] = new SocketAdapter(ip, Integer.parseInt(port));
	            return s;
	        }catch (Exception e) {
	        	return null;
	        }
      }
    }
    return s;
  } 

  /**
   * 初始化连接池
   * @throws UnknownHostException 
   * @throws IOException 
   */
  public void init() throws UnknownHostException, IOException { 

    socketpool = new SocketAdapter[max_size];

    for (int i = 0; i < max_size; i++) {
    	object_lock_list[i]=new Object();
    }
  
    System.out.println("SocektConnectionPoolProvider init success ....");
  } 

  /**
   * 重新启动连接池

   * @throws UnknownHostException
   * @throws IOException
   */
  public void restart() throws UnknownHostException, IOException {
         destroy();
         init();
  } 

  /**
   * 注销此连接池
   * @throws IOException 
   */
  public void destroy() throws IOException {
    for (int i = 0; i < socketpool.length; i++) {
      if (socketpool[i] != null) {
        SocketAdapter adapter = (SocketAdapter) socketpool[i];
        adapter.destroy();
      }
    }
    System.out.println("\n destory success ....");
  }
  /**
   * 生成此连接池实现的对象
   * @throws UnknownHostException
   * @throws IOException 
   * @return ConnectionProvider 
   */
  public static ConnectionProvider newInstance() throws
      UnknownHostException, IOException {
    if (provider == null) {
      synchronized (object_lock) {
        if (provider == null) {
          provider = new MySocektConnectionPoolProvider();
        }
      }
    }
    return provider;
  }
/**
 * 读取properties文件。
 * @param key
 * @param properName
 * @return
 */
  public static String readProperties(String key, String properName) {
		ResourceBundle rsrc = null;
		String value = "";
		rsrc = ResourceBundle.getBundle(properName);
		value = rsrc.getString(key);
		return value;

  }
}
