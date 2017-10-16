package io.test.nettytest.jbossmarshalling;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class SubReqServerHandler extends ChannelHandlerAdapter {
	
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		SubscribeReq req = (SubscribeReq)msg;
		
		if("subscriber".equalsIgnoreCase(req.getUsername())){
			
			System.out.println("service accept client subscribe req : "+req.toString());
			ctx.writeAndFlush(new SubscribeResp(req.getSubReqID(), 0, "Netty book order succed, 3 days later,sent to the designated address"));
			
		}
	
	}


	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		
		ctx.close();
	}
	
	

}
