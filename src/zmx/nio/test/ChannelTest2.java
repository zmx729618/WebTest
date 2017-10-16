package zmx.nio.test;


import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class ChannelTest2 {
    static private final byte message[] = {83, 111, 109, 101, 32,
        98, 121, 116, 101, 115, 46};

    static public void main( String args[] ) throws Exception {
        FileOutputStream fout = new FileOutputStream("D:\\projects\\testWeb\\src\\zmx\\nio\\test\\test.txt",true);
        
        FileChannel fc = fout.getChannel();
        
        ByteBuffer buffer = ByteBuffer.allocate( 1024 );
        
        for (int i=0; i<message.length; ++i) {
            buffer.put( message[i] );
        }
        
        buffer.flip();
        
        fc.write( buffer );
        
        fout.close();
    }
}