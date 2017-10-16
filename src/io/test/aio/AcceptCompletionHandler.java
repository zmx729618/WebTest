package io.test.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;


public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

	@Override
	public void completed(AsynchronousSocketChannel socketChannel,
			AsyncTimeServerHandler attachment) {
		attachment.asynchronousServerSocketChannel.accept(attachment,this);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		socketChannel.read(buffer,buffer,new ReadCompletionHandler(socketChannel));
	}

	@Override
	public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
		exc.printStackTrace();
		attachment.countDownLatch.countDown();
		
	}

}
