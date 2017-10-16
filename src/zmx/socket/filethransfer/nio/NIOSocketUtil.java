package zmx.socket.filethransfer.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * NIO的工具类
 * @author zhangwenchao
 *
 */
public class NIOSocketUtil {

	    /**
	     * 
	     * @param dst
	     * @return
	     */
	    public static String byteBufferToString(ByteBuffer byteBuffer) {  
	        String result = null;  
	        if (byteBuffer != null) {  
	        	byteBuffer.flip();  
	            byte[] tempb = new byte[byteBuffer.limit()];  
	            byteBuffer.get(tempb);  
	            result = new String(tempb);  
	        }  
	        return result;  
	    }
	    
	    /**  
	     * @param s
	     * @return
	     */
	    public static ByteBuffer stringToByteBuffer(String s) {  
	        ByteBuffer byteBuffer = null;  
	        if (s != null) {  
	        	byteBuffer = ByteBuffer.wrap(s.getBytes());  
	        }  
	        return byteBuffer;  
	    }
	    
	    
	    /**
	     * 写buffer到SocketChannel中
	     * @param socketChannel
	     * @param buffer
	     * @throws IOException
	     */
	    public static ByteBuffer readBufferFromChannel(SocketChannel socketChannel,ByteBuffer buffer) throws IOException {  
	    	   buffer.clear(); 
    	       socketChannel.read(buffer);  
    	       return buffer;
	    }
	    
	    
	    /**
	     * 写buffer到SocketChannel中
	     * @param socketChannel
	     * @param buffer
	     * @throws IOException
	     */
	    public static void writeBufferToChannel(SocketChannel socketChannel,ByteBuffer buffer) throws IOException {                   
    	       buffer.flip();  
    	       socketChannel.write(buffer);  
    	       buffer.clear();  
	    }
	    
	     
	    public static void readFileToChannel(SocketChannel socketChannel, String filePath,ByteBuffer buffer) throws IOException{
	    	
                        File file = new File(filePath);  
                        FileChannel fileChannel = new FileInputStream(file).getChannel();                                         
                        try {
                            buffer.clear();
                            int i = 1;
                            int num = 0;  
                            while ((num=fileChannel.read(buffer)) !=-1) {  
                                buffer.flip();                        
                                int send = socketChannel.write(buffer);   //发送数据；
                                System.out.println("i===========" + (i++) + "   num:" + num + " send:" + send);
                                // 可能因为接收方缓存区满，而导致数据传输失败，需要重新发送
                                while(send == 0){
                                    Thread.sleep(10);
                                    send = socketChannel.write(buffer);
                                    System.out.println("i重新传输====" + i + "   num:" + num + " send:" + send);
                                }
                                buffer.clear();  
                            }  
     
 
                            
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            try {
                            	fileChannel.close();
                            	socketChannel.close();                       
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                 
                        }

	    }
	       
	    
	    /**
	     * 
	     * @param socketChannel
	     * @param fileReadChannel
	     * @param buffer
	     * @throws IOException
	     */
	    public static void writeFileFromChannel(SocketChannel socketChannel,String filePath,ByteBuffer buffer) throws IOException  {  
	    	        File file = new File(filePath);  
	    	        FileChannel fileChannel = new FileOutputStream(file).getChannel();
	    	        buffer.clear();    
	    	        int num = 0;  
	    	        try {  
	    	            while ((num = socketChannel.read(buffer)) > 0) {  
	    	                buffer.flip();  
	    	                // 写入文件  
	    	                fileChannel.write(buffer);  
	    	                buffer.clear();  
	    	            }  
	    	        } catch (IOException e) {   
	    	            e.printStackTrace();  
	    	            return;  
	    	        }  
	    	        // 调用close为-1 到达末尾  
	    	        if (num == -1) {  
	    	            fileChannel.close();  
	    	            System.out.println("接收完毕");  
	    	            buffer.put("success".getBytes());  
	    	            buffer.clear();  
	    	            socketChannel.write(buffer); //  
	    	        }  
	    	    }


	    
	    /**
	     * 
	     * @param path
	     * @param buf
	     * @throws IOException
	     */
	    public static void WriteToFile(String path, ByteBuffer buf) throws IOException {  
        	FileChannel fileChannel =null;      
	        if (fileChannel == null) {  
	            fileChannel = new RandomAccessFile(path, "rw").getChannel();  
	        }  
	        buf.flip();  
	        fileChannel.write(buf);  
	        buf.clear();  
	    }  
	      
  
	    public static int ReadFromFile(String path, ByteBuffer buf) throws IOException {  
	    	FileChannel fileChannel =null;  
	        if (fileChannel == null) {  
	            fileChannel = new RandomAccessFile(path, "r").getChannel();  
	        }  
	          
	        buf.clear();  
	        return fileChannel.read(buf);  
	    }  

	 
	
	

}
