package io.test.nettytest.jbossmarshalling;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;

public class SubReqClientHandler extends ChannelHandlerAdapter {
	
	private static final Logger logger = Logger.getLogger(SubReqClientHandler.class);
	
	/**
	 * 客户端连接成功之后，线程会调用该方法
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		for(int i=0; i<10; i++){ //构造10条消息
			SubscribeReq message  = new SubscribeReq(i, "subscriber", "Netty权威指南", "137********", "北京市海淀区板井曙光花园中路农科大厦A717");
			ctx.write(message); 
		}
		ctx.flush();  //一次性发送给服务器，TCP会对请求消息进行粘包和拆包处理，但是使用解码和编码器没有影响最终结果。
		
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		SubscribeResp respMsg = (SubscribeResp)msg;
		System.out.println("Receive server response :"+respMsg);
		
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
