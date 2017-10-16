package io.test.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable {
	
	private Socket socket;
	
	public TimeServerHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
		BufferedReader in  = null;
		PrintWriter out = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream())); //获取输入字节流并转换为字符流
			out = new PrintWriter(this.socket.getOutputStream(),true); //自动刷新
			String currentTime = null;
			String body = null;
			while(true){
				
				body= in.readLine();
				if(body ==null){
					System.out.println("服务器未接受到数据，断开连接");
					break;	
				}
				System.out.println("服务器接受数据："+body);
				currentTime="query time order".equalsIgnoreCase(body)? new Date(System.currentTimeMillis()).toString() : "bad order";
				out.println(currentTime);				
			 }
					
		} catch (IOException e) {
			if(in !=null){
				try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if(out !=null){
				out.close();
				out = null;
				
			}
			
			if(this.socket !=null){
				try {
					this.socket.close();
					this.socket = null;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		}
		

	}

}
