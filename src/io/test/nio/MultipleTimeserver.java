package io.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;



public class MultipleTimeserver implements Runnable{
	
	private Selector selector;
	
	private ServerSocketChannel serverSocketChannel;
	
	private volatile boolean stop=false;
	
	public MultipleTimeserver(int port) { //初始化serversocketChannel，打开server socket/绑定端口/创建多路复用选择器/注册serverSocketChannel到selector
		
		try {
			//step4. 创建多路复用器Selector 
			selector = Selector.open();
			
			//step1. 打开ServerSocketChannel，用于监听客户端连接，是所有客户端连接的父管道
			serverSocketChannel = ServerSocketChannel.open();
			
			//step3. 设置连接为非阻塞
			serverSocketChannel.configureBlocking(false);
			
			//step2. 绑定监听端口
			serverSocketChannel.socket().bind(new InetSocketAddress(port));
					
			//将ServerSocketChannel注册到 Selector上, 注册一个连接事件
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			
			System.out.println(" 服务器启动在"+port+"端口监听...");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	public void stop(){
		this.stop = true;
	}
	
	
	
	@Override
	public void run() {
		
		while(!stop){
			try {
				selector.select(1000);   
				//System.out.println("selector is wake up!");
				Set<SelectionKey> selectionKeys =  selector.selectedKeys();
				Iterator<SelectionKey> iter = selectionKeys.iterator();	
				SelectionKey key = null;
				while(iter.hasNext()){
					key  = iter.next();
					iter.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						e.printStackTrace();
						if(key !=null){
							key.cancel();
							if(key.channel() !=null){
							    key.channel().close();
							}
						}					
					}					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
				
		}
		if(selector !=null){
			try {
				selector.close();
			} catch (IOException e) {			
				e.printStackTrace();
			}
		}				
	}


	private void handleInput(SelectionKey key) throws IOException {
		
		if(key.isValid()){
			
			if(key.isAcceptable()){ //处理新的接入请求
			    //接受一个新请求
				ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
				//连接返回socketChannel
				SocketChannel sc  = ssc.accept();
				
				sc.configureBlocking(false);
				
				sc.write(ByteBuffer.wrap(new String("客户端连接成功！").getBytes()));
				
				sc.register(selector, SelectionKey.OP_READ);	
			}
			
			if(key.isReadable()){
				SocketChannel sc = (SocketChannel)key.channel();
				ByteBuffer byteBuffer = ByteBuffer.allocate(1024); //新进一个1024容量的ByteBuffer
				int readBytes = sc.read(byteBuffer);
				if(readBytes>0){
					byteBuffer.flip();
					byte[] bytes = new byte[byteBuffer.remaining()];
					byteBuffer.get(bytes);
					String body = new String(bytes,"utf-8");
					System.out.println("服务器收到命令 : "+ body);
					String currentTime="query time order".equalsIgnoreCase(body)? new Date(System.currentTimeMillis()).toString() : "bad order";
					System.out.println("服务器发送数据:"+currentTime);
					doWrite(sc,currentTime);
				}else if(readBytes<0){
					key.cancel();
					sc.close();
				}else{
					//读到0字节，忽略
					;
				}
			}
			
		}
		
	}


	private void doWrite(SocketChannel sc, String response) throws IOException {
		if(response !=null && response.trim().length() > 0 ){
			
			byte[] bytes = response.getBytes("utf-8");
			ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
			byteBuffer.put(bytes);
			byteBuffer.flip();
			sc.write(byteBuffer); //由于socketChannel是异步非阻塞的，并不能保证一次能够把需要发送的字节数发送完毕，会出现"写半包"的问题，
			
			// 需要注册写操作，不断轮询Selector将没有发送完的ByteBuffer发送完毕。
			/*if(byteBuffer.hasRemaining()){
				
			}*/
			
		}
		
	}

}
