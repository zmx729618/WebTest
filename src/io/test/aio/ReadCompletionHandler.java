package io.test.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

public class ReadCompletionHandler implements
		CompletionHandler<Integer, ByteBuffer> {
	
	private AsynchronousSocketChannel channel;
	
	public ReadCompletionHandler(AsynchronousSocketChannel channel) {
		if(this.channel ==null){
		    this.channel =channel;
		}
	}

	@Override
	public void completed(Integer result, ByteBuffer attachment) {
		
		attachment.flip();
		byte[] body  = new  byte[attachment.remaining()];
		attachment.get(body);
		try{
			String request = new String(body,"utf-8");
			System.out.println("服务器收到命令 : "+ request);
			String currentTime="query time order".equalsIgnoreCase(request)? new Date(System.currentTimeMillis()).toString() : "bad order";
			System.out.println("服务器发送数据:"+currentTime);
			doWrite(currentTime);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doWrite(String response) throws UnsupportedEncodingException {
		if(response !=null && response.trim().length() > 0 ){
			byte[] bytes = response.getBytes("utf-8");
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer,writeBuffer, new CompletionHandler<Integer,ByteBuffer>(){
				
				@Override		
				public void completed(Integer result, ByteBuffer buffer) {
					//如果没有发送完成，继续发送
					if(buffer.hasRemaining()){
						channel.write(buffer,buffer,this);
					} 
							
				}

				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					
					try {
						channel.close();
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
			this.channel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
