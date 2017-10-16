package zmx.nio.test;


import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class ChannelTest {
	
	
    static public void main( String args[] ) throws Exception {
        FileInputStream fin = new FileInputStream("D:\\projects\\testWeb\\src\\zmx\\nio\\test\\test.txt");
        
        // 获取通道
        FileChannel fc = fin.getChannel();
        
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        
        // 读取数据到缓冲区
        fc.read(buffer);
        byte[] bytes = buffer.array();
        System.out.println(new String(bytes));
        buffer.flip();
        
        while (buffer.remaining()>0) {
            byte b = buffer.get();
            System.out.print(((char)b));
        }
        
        fin.close();
    }
    
    
}