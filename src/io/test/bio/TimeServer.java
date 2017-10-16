package io.test.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 同步阻塞IO测试
 * @author zhangwenchao
 *
 */
public class TimeServer {
	private  static int port=8989;
	public static void main(String[] args) {
		
		if(args !=null && args.length >0){
			try {
				port =Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				port=8989;
			}	
		}
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("端口:"+port+"上开始监听...");
			Socket socket = null;
			while(true){
				
			   socket = serverSocket.accept();  //一直阻塞，直到有socket打开
			   
			   new Thread(new TimeServerHandler(socket)).start();  //开启新线程处理请求
			 
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}finally{
			if(serverSocket !=null){
				System.out.println("服务器关闭");
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				serverSocket =null;
				
			}
		}
		
	}

}
