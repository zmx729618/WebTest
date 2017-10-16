package zmx.nio.test.myftpbio;


import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class FtpServerHandler implements FtpHandler {

	private ServerSocketChannel ssc;
	
	public FtpServerHandler(Selector selector, ServerSocketChannel ssc) {
		this.ssc = ssc;
	}
	
	@Override
	public void execute(SelectionKey key) {
		try {
			// get client socket channel
			SocketChannel lsockChannel = null;
			lsockChannel = ssc.accept();
			
			// read data from client socket channel
			ByteBuffer dst = ByteBuffer.allocate(1024);
			lsockChannel.read(dst);
			String cmd = FtpServer.ByteBufferToString(dst);
			
			// set the connect number
			FtpServer.connum.set(FtpServer.connum.get() + 1);
			
			// print the client info
			System.out.println(FtpServer.connum.get() + " client:" + lsockChannel.socket().getRemoteSocketAddress().toString() + " cmd:" + cmd);
			
			// deal Command
			try {
				processCmd(cmd, lsockChannel);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void processCmd(String cmd, SocketChannel lsockChannel) throws IOException {
		if (cmd.toLowerCase().equals("ls")) {
			lsCmd(cmd, lsockChannel);
			return;
		}
		
		if (cmd.toLowerCase().startsWith("download")) {
			downloadCmd(cmd, lsockChannel);
			return;
		}
		
		if (cmd.toLowerCase().startsWith("upload")) {
			uploadCmd(cmd, lsockChannel);
			return;
		}
		
		// send client with data:no match command
		ByteBuffer other = FtpServer.StringToByteBuffer("cmd not exist, please check you command and try again!!!");		
		lsockChannel.write(other);
		
		//close SocketChannel
		lsockChannel.close();
	}
	
	public void lsCmd(String cmd, SocketChannel lsockChannel) throws IOException {
		File dir = new File(FtpServer.ROOT);
		File files[] = dir.listFiles();
		
		String ret = null;
		for (File f : files) {
			if (ret == null) {
				ret = f.getName();
			} else {
				ret += ";";
				ret += f.getName();
			}
		}
		
		ByteBuffer src = null;
		if (ret != null) {
			src = ByteBuffer.wrap(ret.getBytes());
		} else {
			String error = "cmd execute fail!!!";
			src = ByteBuffer.wrap(error.getBytes());
		}
		
		// write data to client socket channel
		lsockChannel.write(src);
		
		//close SocketChannel
		lsockChannel.close();
	}
	
	public void downloadCmd(String cmd, SocketChannel lsockChannel) throws IOException {
		String f[] = cmd.split(":");
		String filepath = FtpServer.ROOT + f[1];
		
		Runnable r = new DownLoadFile(filepath, lsockChannel);
		FtpServer.exc.execute(r);
		
		return;
	}
	
	public void uploadCmd(String cmd, SocketChannel lsockChannel) throws IOException {
		String f[] = cmd.split(":");
		String tmp[] = f[1].split("/");
		String filepath = FtpServer.ROOT + tmp[tmp.length -1];
		
		Runnable r = new UpLoadFile(filepath, lsockChannel);
		FtpServer.exc.execute(r);
				
		return;
	}
}

