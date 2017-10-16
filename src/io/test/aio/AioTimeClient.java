package io.test.aio;

public class AioTimeClient {
	
	public static void main(String[] args) {
		int port=8999;
		if(args !=null && args.length >0){
			try {
				port =Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				port=8999;
			}	
		}
		
		
		new  Thread(new AsyncTimeClientHandler("127.0.0.1",port),"AIO-AsyncTimeClientHandler").start();
		
		
	}

}
