package zmx.nio.test.myftpbio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class DownLoadFile implements Runnable {

	private String filepath;
	private SocketChannel lsockChannel;
	
	public DownLoadFile(String filepath, SocketChannel lsockChannel) {
		this.filepath = filepath;
		this.lsockChannel = lsockChannel;
	}
	
	@Override
	public void run() {
		
		try {
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			fis = new FileInputStream(filepath);
			if (fis != null) {
				bis = new BufferedInputStream(fis);
				
				if (bis != null) {
					
					byte[] bs = new byte[512];	
					while(bis.available() > 512) {
						bis.read(bs);
						ByteBuffer src = ByteBuffer.wrap(bs);
						// write data to client socket channel
						lsockChannel.write(src);
						Arrays.fill(bs, (byte)0);
					}
					
					// 处理不足512的剩余部分
					int remain = bis.available(); 
					byte[] last = new byte[remain];
					bis.read(last);
					lsockChannel.write(ByteBuffer.wrap(last));
	             
					// release resource
					bis.close();
					fis.close();
					lsockChannel.close();
				} 
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

