package io.test.nettytest.httpserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
	
	
	private static final String BAD_REQUEST = "405";
	private final String url;
	
	public  HttpFileServerHandler(String url){
		this.url = url;
	}
	
	


    /**
     * 
     */
	@Override
	protected void messageReceived(ChannelHandlerContext ctx,
			FullHttpRequest request) throws Exception {
		
		if(!request.getDecoderResult().isSuccess()){
			
			return;
		}
	}

}
