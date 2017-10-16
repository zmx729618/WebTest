package io.test.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeClientHandler implements CompletionHandler<Void,AsyncTimeClientHandler>,Runnable {
	
	private AsynchronousSocketChannel clientSocketChannel;
	private String host;
	private int port;
	private CountDownLatch countDownLatch;
	
	public AsyncTimeClientHandler(String host,int port) {
		this.host = host;
		this.port = port;
		try {
			clientSocketChannel= AsynchronousSocketChannel.open();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
				
	}

	@Override
	public void run() {
		
		countDownLatch = new CountDownLatch(1);
		
		clientSocketChannel.connect(new InetSocketAddress(host, port), this, this);
		
		try {
			
			countDownLatch.await();  //让当前线程等待，直到countDownLatch减为0;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		try {
			clientSocketChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void completed(Void result, AsyncTimeClientHandler attachment) {
		try {
			byte[] request = "query time order".getBytes("utf-8");
			ByteBuffer writeBuffer = ByteBuffer.allocate(request.length);
			writeBuffer.put(request);
			writeBuffer.flip();
			clientSocketChannel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {

				@Override
				public void completed(Integer result, ByteBuffer buffer) {
					
					if(buffer.hasRemaining()){ //如果数据还没有发送完，继续发送
						clientSocketChannel.write(buffer, buffer, this);
					}else{  //如果数据发送完
						ByteBuffer readBuffer = ByteBuffer.allocate(1024);
						clientSocketChannel.read(readBuffer, readBuffer, 
								new CompletionHandler<Integer, ByteBuffer>(){

							@Override
							public void completed(Integer result,ByteBuffer buffer) {
								buffer.flip();
								byte[] bytes = new byte[buffer.remaining()];
								buffer.get(bytes);
								try {
									String body = new String(bytes,"utf-8");
									System.out.println("客户端 接受数据：Now is "+body);
									countDownLatch.countDown();
								} catch (UnsupportedEncodingException e) {
									e.printStackTrace();
								}
								
								
							}

							@Override
							public void failed(Throwable exc,
									ByteBuffer attachment) {
								
								try {
									clientSocketChannel.close();
									countDownLatch.countDown();
								} catch (IOException e) {
									e.printStackTrace();
								}
								
							}
							
						});
						
						
					}
				}

				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					
					try {
						clientSocketChannel.close();
						countDownLatch.countDown();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			});
			
			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
		exc.printStackTrace();
		try {
			clientSocketChannel.close();
			countDownLatch.countDown();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
