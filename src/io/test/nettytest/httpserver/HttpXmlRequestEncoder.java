package io.test.nettytest.httpserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;

import java.net.InetAddress;
import java.util.List;

public class HttpXmlRequestEncoder extends AbstractHttpXmlEncoder<HttpXmlRequest> {

	@Override
	protected void encode(ChannelHandlerContext ctx, HttpXmlRequest msg,
			List<Object> out) throws Exception {
		ByteBuf body  = encode0(ctx,msg.getBody());
		
		FullHttpRequest request = msg.getRequest();
		
		if(request == null){
			
			request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/do",body);
			
			HttpHeaders headers = request.headers();
			
			headers.set(HttpHeaders.Names.HOST,InetAddress.getLocalHost().getHostAddress());
			
			headers.set(HttpHeaders.Names.CONNECTION,HttpHeaders.Values.CLOSE);
			
			HttpHeaders.setContentLength(request, body.readableBytes());
			
			out.add(request);
		}
		
	}

	

}
