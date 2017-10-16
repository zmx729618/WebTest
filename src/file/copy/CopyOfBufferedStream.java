package file.copy;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;

public class CopyOfBufferedStream {
	
	public static void main(String[] args){  
        long start = System.currentTimeMillis();  
        BufferedInputStream fileInputStream = null;  
        BufferedOutputStream fileOutputStream = null;  
        try {  
            fileInputStream = new BufferedInputStream( new FileInputStream(new File("D:\\from\\测试视频文件.avi")));  
            fileOutputStream = new BufferedOutputStream(new FileOutputStream(new File("D:\\to\\测试视频文件.avi")));  
            byte[] bufferArray = new byte[1024*1024];     
            int length;     
            while ((length = fileInputStream.read(bufferArray)) != -1) {     
                fileOutputStream.write(bufferArray, 0, length);     
            }    
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if(fileInputStream != null){  
                    fileInputStream.close();  
                }  
                if(fileOutputStream != null){  
                    fileOutputStream.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        long end = System.currentTimeMillis();  
        System.out.println("视频文件从“from”文件夹复制到“to”文件需要" + (end - start) + "毫秒。");  
    }  


}
