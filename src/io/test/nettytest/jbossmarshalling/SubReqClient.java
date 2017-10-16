package io.test.nettytest.jbossmarshalling;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class SubReqClient {
	
	
	public void connect(int port,String host) throws Exception{
		
		//配置客户端NIO线程组
		EventLoopGroup group =  new NioEventLoopGroup();
		
		try{
			
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
			 .option(ChannelOption.TCP_NODELAY, true)
			 .handler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					
					ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
					ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
					ch.pipeline().addLast(new SubReqClientHandler());
				}
				 
			});
			
			//发起同步连接操作
			ChannelFuture f =  b.connect(host, port).sync();
			f.channel().closeFuture().sync();
			
		}finally{
			
			group.shutdownGracefully();
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception{
		int port=8999;
		if(args !=null && args.length >0){
			try {
				port =Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				port=8999;
			}	
		}

		new SubReqClient().connect(port, "127.0.0.1");
	}
	
	

}
