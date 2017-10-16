package io.test.aio.server;



/**
 * AIO服务端
 * @author yangtao__anxpp.com
 * @version 1.0
 */
public class AIOServerNormal {
	private static int DEFAULT_PORT = 12345;
	private static AsyncServerHandler serverHandler;
	public volatile static long clientCount = 0;
	public static void start(){
		start(DEFAULT_PORT);
	}
	public static synchronized void start(int port){
		if(serverHandler!=null)
			return;
		serverHandler = new AsyncServerHandler(port);
		new Thread(serverHandler,"Server").start();
	}
	public static void main(String[] args){
		AIOServerNormal.start();
	}
}
