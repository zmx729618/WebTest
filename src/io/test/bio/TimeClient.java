package io.test.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {

	private  static int port=8989;
	public static void main(String[] args) {
		
		if(args !=null && args.length >0){
			try {
				port =Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				port=8989;
			}	
		}
		
		Socket socket = null;
		BufferedReader in = null;		
		PrintWriter out = null;						
		
		try {
			socket = new Socket("127.0.0.1",port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new  PrintWriter(socket.getOutputStream(),true);
			
			out.println("query time order");
			
			System.out.println("send order 2 server succeed.");
			
			String resp = in.readLine();
			System.out.println("Now is "+ resp);	
		}catch (IOException e) {
			
			e.printStackTrace();
		}finally{
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
			
			if(socket !=null){
				try {
					socket.close();
					socket = null;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		}
		
		
		
		
	}

}
