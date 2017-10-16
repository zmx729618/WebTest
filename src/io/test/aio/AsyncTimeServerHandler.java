package io.test.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable {
	
	public CountDownLatch countDownLatch;
	
	public AsynchronousServerSocketChannel asynchronousServerSocketChannel;
	
	public AsyncTimeServerHandler(int port){	
				
		try {
			asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
			asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
			System.out.println("the time server is started in port: "+ port);
		} catch (IOException e) {
			e.printStackTrace();
		}
				
				
	}

	@Override
	public void run() {
		
		countDownLatch = new CountDownLatch(1);
		
		doAccept();
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void doAccept(){
		
		asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler());
		
	}

}
