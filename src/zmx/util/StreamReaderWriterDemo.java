package zmx.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
;

public class StreamReaderWriterDemo {
	
	public static void main(String[] args) {
		  try { 
			   
			   BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\projects\\testWeb\\src\\zmx\\util\\test.txt")));
			   
			   BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\projects\\testWeb\\src\\zmx\\util\\test2.txt")));
			   
			   int ch = 0;
			   
			   // 以字符方式显示文件内容 
			   while((ch = bufr.read()) != -1) {
			    System.out.print((char)ch); 
			    bufw.write(ch); 
			   }
			   if(bufr!=null)
			    bufr.close();
			   if(bufw!=null)
			    bufw.close();
			  } catch(ArrayIndexOutOfBoundsException e) {
			   e.printStackTrace();
			  } catch(IOException e) {
			   e.printStackTrace();
			  }
	}

}
