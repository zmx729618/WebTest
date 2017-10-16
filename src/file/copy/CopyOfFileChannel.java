package file.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyOfFileChannel {
	
	public static void main(String[] args){  
        long start = System.currentTimeMillis();  
        FileInputStream fileInputStream = null;  
        FileOutputStream fileOutputStream = null;  
        FileChannel inFileChannel = null;  
        FileChannel outFileChannel = null;  
        try {  
            fileInputStream = new FileInputStream(new File("D:\\from\\测试视频文件.avi"));  
            fileOutputStream = new FileOutputStream(new File("D:\\to\\测试视频文件.avi"));
            
            
            inFileChannel = fileInputStream.getChannel();  
            outFileChannel = fileOutputStream.getChannel(); 
            
            //方案一直接连接两个通道
             inFileChannel.transferTo(0, inFileChannel.size(), outFileChannel);//连接两个通道，从in通道读取数据写入out通道。   
            
            /*//方案二 使用 字节缓冲区
	        ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
            int length=0; 
            while((length = inFileChannel.read(buffer))!=-1 ){
            	buffer.flip();
            	outFileChannel.write(buffer);
            	buffer.clear();
            	
            }*/
            
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if(fileInputStream != null){  
                    fileInputStream.close();  
                }  
                if(inFileChannel != null){  
                    inFileChannel.close();  
                }  
                if(fileOutputStream != null){  
                    fileOutputStream.close();  
                }  
                if(outFileChannel != null){  
                    outFileChannel.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        long end = System.currentTimeMillis();  
        System.out.println("视频文件从“from”文件夹复制到“to”文件需要" + (end - start) + "毫秒。");  
    }  


}
