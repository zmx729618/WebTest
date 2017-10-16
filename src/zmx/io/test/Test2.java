package zmx.io.test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Test2 {
    public static void main(String[] args) throws Exception {  
        File file = new File("D:\\projects\\testWeb\\src\\zmx\\io\\test\\text2.txt");  
        if(!file.exists()) {  
            file.createNewFile();  
        }  
        FileOutputStream fos = new FileOutputStream(file);  
        BufferedOutputStream bos = new BufferedOutputStream(fos);  
        byte[] b = new byte[1024];  
        bos.write(b);  
        bos.flush();  
    }


}
