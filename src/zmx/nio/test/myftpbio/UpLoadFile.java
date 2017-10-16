package zmx.nio.test.myftpbio;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class UpLoadFile implements Runnable {
	private String path;
	private SocketChannel sc;
	
	public UpLoadFile(String path, SocketChannel sc) {
		this.path = path;
		this.sc = sc;
	}
	
	@Override
	public void run() {
		try {
			FileOutputStream fos = null;
			BufferedOutputStream bos = null;
			fos = new FileOutputStream(path);
			
			if (fos != null) {
				bos = new BufferedOutputStream(fos);
				if (bos != null) {
					ByteBuffer dst = ByteBuffer.allocate(512);
					while(true) {
						int n = sc.read(dst);
						if (n == 0) {
							continue;
						}
						
						if (n == -1) {
							break;
						}
						
						// write to file
						dst.flip();
						byte[] tempb = new byte[dst.limit()];
						dst.get(tempb);
						bos.write(tempb);	
						dst.clear();
					}
					
					// release resource
					bos.close();
					fos.close();
					sc.close();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

