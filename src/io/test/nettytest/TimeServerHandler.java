package io.test.nettytest;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;


public class TimeServerHandler extends ChannelHandlerAdapter {
	
	private int count;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		String body = (String)msg;
		
		System.out.println("the time server receive order :"+body+"; the count is : "+ ++count);
		
		String currentTime = "query time order".equalsIgnoreCase(body)? new Date(System.currentTimeMillis()).toString(): "bad order";
	
		currentTime =  currentTime + System.getProperty("line.separator");
		
		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
		
		ctx.writeAndFlush(resp);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		
		ctx.close();
	}
	
	


}
