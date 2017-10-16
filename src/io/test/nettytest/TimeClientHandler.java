package io.test.nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;


public class TimeClientHandler extends ChannelHandlerAdapter {
	
	private static final Logger logger = Logger.getLogger(ChannelHandlerAdapter.class);
	
	private int count;
	
	private byte[] req;
	
	
	
	public TimeClientHandler(){
		
		 req = ("query time order" + System.getProperty("line.separator")).getBytes();

	}

	/**
	 * 客户端连接成功之后，线程会调用该方法
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		ByteBuf message = null;
		for(int i=0; i<100; i++){
			message =  Unpooled.buffer(req.length);
			message.writeBytes(req);
			ctx.writeAndFlush(message);
		}
		
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		String body = (String)msg;
		
		System.out.println("Now is :"+body+" the count is:"+ ++count);
		

	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		
		ctx.flush();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		logger.warn(cause.getMessage());
		ctx.close();
	}



	


}
