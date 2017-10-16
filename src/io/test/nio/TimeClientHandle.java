package io.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeClientHandle implements Runnable {
	
	private String host;
	
	private int port;
	
	private Selector selector;
	
	private SocketChannel socketChannel;
	
	private volatile boolean stop=false;
	

	
	public TimeClientHandle(String host,int port) {
		this.host = host==null ?  "127.0.0.1": host ;
		this.port = port;
		try {
			selector = Selector.open();
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
	        //用channel.finishConnect();才能完成连接  
			//socketChannel.connect(new InetSocketAddress(this.host,this.port));  
	        //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件。  
			//socketChannel.register(this.selector, SelectionKey.OP_CONNECT);
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
		try {
			doConnect();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(1);
		}
		
		
		while(!stop){
			try {
				this.selector.select(1000);   //
				//System.out.println("selector is wake up!");
				Set<SelectionKey> selectionKeys =  this.selector.selectedKeys();
				Iterator<SelectionKey> iter = selectionKeys.iterator();
				SelectionKey key = null;
				while(iter.hasNext()){
					key  = iter.next();
					iter.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if(key !=null){
							key.cancel();
							if(key.channel()!=null){								
								key.channel().close();
							}
						}
					}
					
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
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
	
	

	private void handleInput(SelectionKey key) throws IOException, IOException {
		
        if(key.isValid()){
        	//获取SocketChannel
			SocketChannel sc = (SocketChannel)key.channel(); //获取socketchannel
			if(key.isConnectable()){ //如果是：连接key
				// 如果正在连接，则完成连接  
                if(sc.finishConnect()){
                	// 设置成非阻塞  
                    sc.configureBlocking(false);
                	System.out.println("连接成功，发送数据: query time order");
                	sc.register(selector, SelectionKey.OP_READ); //注册read的key
                	doWrite(sc,"query time order"); //写数据
                }else{
					System.exit(1); //连接失败
				}			
			}
			if(key.isReadable()){
				ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(byteBuffer);
				if(readBytes>0){
					byteBuffer.flip();
					byte[] bytes = new byte[byteBuffer.remaining()];
					byteBuffer.get(bytes);
					String body = new String(bytes,"utf-8");
					System.out.println("Now is ： "+ body);
					
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

	private void doConnect() throws IOException {
		System.out.println("连接主机："+host+"端口："+port+"中...");
		if(socketChannel.connect(new InetSocketAddress(host, port))){ //如果请求连接主机，如果请求连接成功，注册：读SelectionKey
			socketChannel.register(selector, SelectionKey.OP_READ);			
		}else{
			socketChannel.register(selector, SelectionKey.OP_CONNECT); //如果请求主机没有成功，注册：连接SelectionKey
		}
		
	}

	private void doWrite(SocketChannel sc, String response) throws IOException {
		
		byte[] bytes = response.getBytes("utf-8");
		ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
		byteBuffer.put(bytes);
		byteBuffer.flip();
		sc.write(byteBuffer); //由于socketChannel是异步非阻塞的，并不能保证一次能够把需要发送的字节数发送完毕，会出现"写半包"的问题，
		
		// 需要注册写操作，不断轮询Selector将没有发送完的ByteBuffer发送完毕。
		if(!byteBuffer.hasRemaining()){//数据发送完毕
			System.out.println("send data successed！");
		}else{//数据没有发送完成
			//注册写事件，继续写数据。
		}
	}

}
