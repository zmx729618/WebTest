package zmx.nio.test.myftpbio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FtpServer {
	public final static int PORT = 5000;
	public final static String ROOT = "D:/FtpDir/";
	public static AtomicInteger connum = new AtomicInteger(0);
	
	public static ExecutorService exc = Executors.newCachedThreadPool();
	
	public static void main(String argv[]) {
		
		try {
			Selector s = Selector.open();
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);
			SelectionKey key = ssc.register(s, SelectionKey.OP_ACCEPT);
			key.attach(new FtpServerHandler(s, ssc));
			
			ServerSocket ss = ssc.socket();
			ss.bind(new InetSocketAddress(PORT));
			
			System.out.println("Start ftp server on " + PORT);
			
			while (!Thread.interrupted()) {
				
				int n = s.select();
				
				if (n == 0) {
					continue;
		        }
				
				Iterator<SelectionKey> it = s.selectedKeys().iterator();
	            while (it.hasNext()) 
	            {
	                SelectionKey sk = it.next();
	                it.remove();
	                
	                FtpHandler handler = (FtpHandler) sk.attachment();
					handler.execute(sk);
	            }
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String ByteBufferToString(ByteBuffer dst) {
		String ret = null;
		if (dst != null) {
			dst.flip();
			byte[] tempb = new byte[dst.limit()];
			dst.get(tempb);
			ret = new String(tempb);
		}
		return ret;
	}
	
	public static ByteBuffer StringToByteBuffer(String s) {
		ByteBuffer other = null;
		if (s != null) {
			other = ByteBuffer.wrap(s.getBytes());
		}
		return other;
	}
}

