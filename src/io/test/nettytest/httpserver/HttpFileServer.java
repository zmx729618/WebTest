package io.test.nettytest.httpserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HttpFileServer {
	
	private static final String DEFAULT_URL = "/src/netty";
	
	public void run(final int port, final String url) throws Exception{
		
		EventLoopGroup bossGroup  = new NioEventLoopGroup();
		
		EventLoopGroup workerGroup  = new NioEventLoopGroup();
		
		try{
			
			ServerBootstrap b  = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
			 .channel(NioServerSocketChannel.class)
			 .childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					
					ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());  //请求解码器
					ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536)); //对象聚合器---用于将多个消息转化为单一的消息对象（FullHttpRequest或者FullHttpResponse）
					ch.pipeline().addLast("http-encoder", new HttpResponseEncoder()); //响应编码器
					ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler()); //响应编码器
					ch.pipeline().addLast("fileServerHandler", new HttpFileServerHandler(url)); //自定义文件服务处理器	
					
				}
				 
				 
			});
			
			ChannelFuture future = b.bind(port).sync();
			System.out.println("http文件目录服务器启动...");	
			future.channel().closeFuture().sync();
		}finally{
			
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
			
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception{
		
		int port = 8080;
		if(args.length > 0){
			try{
				port =  Integer.parseInt(args[0]);
			}catch(NumberFormatException e){
				port = 8080;
			}
		}
		String url = DEFAULT_URL;
		if(args.length > 1){
			url = args[1];
		}
		
		new HttpFileServer().run(port, url);
		
	}

}
