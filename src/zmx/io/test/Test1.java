package zmx.io.test;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Test1 {
	
    public static void main(String[] args) throws Exception {  
        File file = new File("D:\\projects\\testWeb\\src\\zmx\\io\\test\\text1.txt");  
        if(!file.exists()) {  
            file.createNewFile();  
        }  
        FileOutputStream fos = new FileOutputStream(file);   
        DataOutputStream dos = new DataOutputStream(fos);  
        dos.writeBytes("java io");  
    }


}
