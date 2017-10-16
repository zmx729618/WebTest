package zmx.socket.pool;



import java.util.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;

import zmx.thread.pool.PThread;

/**
*
*/
public class MySocketConnectionProvider implements ConnectionProvider { 

	  private Properties pro = null;
	  private static ConnectionProvider provider = null;
	  private static Object object_lock = new Object();
	  private static Object[] object_lock_list = new Object[Integer.parseInt(ResourceBundle.getBundle("config").getString("max_size"))];
	  private String ip;
	  private String port; 
	  private static InetSocketAddress inetSockAddr = null;
	  /**
	   * 默认的最大连接数
	   */
	  private int max_size = 20; 
	
	  /**
	   * 默认的最小连接数 。。。没用
	   */
	  private int min_size = 10; 
	
	  /**
	   * Socket连接
	   * Socket connection
	   */
	  private SocketAdapter[] socketpool = null; 
	
	  /**
	   * 构造对象的时候初始化连接池
	   * @throws UnknownHostException
	   * @throws IOException
	   */
	  private MySocketConnectionProvider() throws UnknownHostException,IOException {
		    ResourceBundle  res =ResourceBundle.getBundle("config");  //获取资源文件
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
	   * 初始化连接池
	   * @throws UnknownHostException 
	   * @throws IOException 
	   */
	  public void init() throws UnknownHostException, IOException { 
	
	    socketpool = new SocketAdapter[max_size]; //开辟内存空间
	
	    for (int i = 0; i < max_size; i++) {
	    	object_lock_list[i]=new Object();
	      }
	  
	    System.out.println("System init success ....");
	  }
	
	  /**
	   * 判断是否已经池化
	   * @return boolean 如果池化返回ture,反之返回false
	   */
	  public boolean isPooled() {
		  
	    if (socketpool != null) {	    	
	        return true;
	    }else{	    	
	    	return false;
	    }
	  } 
	
	  /**
	   * 返回一个连接	
	   * @return a Connection object.
	   * @throws IOException 
	   */
	  public SocketAdapter getConnection(){
		  
		    SocketAdapter s = null;
			for (int i = 0; i < socketpool.length; i++) {
				synchronized (object_lock_list[i]){
					  //System.out.println("loop detail i="+i);
					  if (socketpool[i] != null) {//连接不为空
						    //连接不为空，判断给连接是否正在被使用
					        //如果有空闲的连接，返回一个空闲连接，如果没有，继续循环
						    if(!socketpool[i].isFree()){ //判断该连接是否正在被使用
							         continue;
					    	}else{//如果空闲
					    		
						    		  if(socketpool[i].isFree()){//
						   			      s = socketpool[i];   //返回该空闲的连接
						   		       // System.out.println(i+" socket isConnected()="+s.isConnected()+" binding"+s.isBound());
						   			  try {
						   				  s= socketpool[i] = new SocketAdapter(ip, Integer.parseInt(port));
						   				  socketpool[i].setBusy();
						   				  System.out.println("socket"+i);
						   			  } catch (IOException e) {					
						   				  e.printStackTrace();
						   				  return null;
						   			  }
						   			  return s;
						    		 }else{
						    			 continue;
						    		 }
					    		
					    	}
					    
					  }else{ //如果连接为空，证明超过最小连接数，重新生成连接
						  
						  
							  try {
							    	System.out.println("new socket"+i);
							        s = socketpool[i] = new SocketAdapter(ip, Integer.parseInt(port));
							        socketpool[i].setBusy();
							        return s;
							    }catch (Exception e) {
							           //never throw
							        	return null;
							    }
						
						   
					  }
				}
		   }
	       return s;
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
		        System.out.print("socket is closed");
		      }
	     }
	     System.out.println("\n  destory success ....");
	  }
	  /**
	   * 生成此连接池实现的对象
	   * @throws UnknownHostException
	   * @throws IOException 
	   * @return ConnectionProvider 
	   */
	  public static ConnectionProvider newInstance() throws UnknownHostException, IOException {
	    if (provider == null) {
		    synchronized (object_lock){
			        if (provider == null) {
			            provider = new MySocketConnectionProvider();  
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
	  
	  
	  public static void main(String[] args) throws Exception {
		  
		  
		  // 连接池 
		  final ConnectionProvider conpool = MySocketConnectionProvider.newInstance();
		  //获取新的connection 
		  Socket connection1= conpool.getConnection();  
		  Socket connection2= conpool.getConnection(); 
		  Socket connection3= conpool.getConnection(); 
		  System.out.println(">>>>>>>>>>>>>>>"+connection1);
		  System.out.println(">>>>>>>>>>>>>>>"+connection2);
		  System.out.println(">>>>>>>>>>>>>>>"+connection3);
		  connection1.close();
		  connection2.close();
		  connection3.close();
		  
		  while(true){
			  
			  Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						  Socket connection= conpool.getConnection();  
						  if(connection!=null){  
							  
							  BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));// 接受  
							  PrintWriter out = new PrintWriter(connection.getOutputStream(), true);// 传输
						  }
						  Thread.sleep(2000);
						  connection.close();
					} catch (Exception e) {
						
					}
					
				}
			});
			  
			t.start();  
			  
		  }
		  
		  


		
	  }
}
