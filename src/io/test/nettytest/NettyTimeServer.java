package io.test.nettytest;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class NettyTimeServer {
	
	public void bind(int port) throws Exception{
		
		
		//配置服务端的NIO线程组
		EventLoopGroup bossGroup =  new  NioEventLoopGroup();
		EventLoopGroup workerGroup = new  NioEventLoopGroup();
		
		try{
			
			ServerBootstrap b = new  ServerBootstrap();
			b.group(bossGroup, workerGroup)
			 .channel(NioServerSocketChannel.class)
			 .option(ChannelOption.SO_BACKLOG, 1024)
			 .childHandler(new ChildChannelHandler());
			
			//绑定端口，同步等待成功
			ChannelFuture f = b.bind(port).sync();
			
			//等待服务端监听端口关闭
			f.channel().closeFuture().sync();
			
		}catch (Exception e) {
			
		}finally{
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
				
	}
	
	private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			
		  //ch.pipeline().addLast(new LineBasedFrameDecoder(1024),new StringDecoder(),new TimeServerHandler());
			ch.pipeline().addLast(new LineBasedFrameDecoder(1024));  //以回车换行作为消息结束符
		//	ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, Unpooled.copiedBuffer("$_".getBytes())));   //将特殊的分隔符作为消息的结束符 
		//	ch.pipeline().addLast(new FixedLengthFrameDecoder(20)); //
			ch.pipeline().addLast(new StringDecoder());
			ch.pipeline().addLast(new TimeServerHandler());
			
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		
		int port=8999;
		if(args !=null && args.length >0){
			try {
				port =Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				port=8999;
			}	
		}
						
		new NettyTimeServer().bind(port);
		

	}
	
	
	
	

}
