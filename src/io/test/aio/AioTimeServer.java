package io.test.aio;


public class AioTimeServer {
	
	public static void main(String[] args) {
		int port=8999;
		if(args !=null && args.length >0){
			try {
				port =Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				port=8999;
			}	
		}
		
		
		new Thread(new AsyncTimeServerHandler(port),"AIO-AsyncTimeServerHandler").start();
		
		
	}

}
