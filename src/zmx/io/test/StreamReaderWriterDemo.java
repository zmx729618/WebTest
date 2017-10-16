package zmx.io.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamReaderWriterDemo {
	
	public static void main(String[] args) {
		  try { 
			   //1.从文本文件中获得输入字节到字节输入流中
			   FileInputStream fis = new FileInputStream("D:\\projects\\testWeb\\src\\zmx\\io\\test\\01.txt"); 
			   
			   //2. 为FileInputStream加上字符处理功能
			   InputStreamReader isr = new InputStreamReader(fis,"utf-8"); //将字节流转换成字符流
			   
			   //3.为了达到最高效率，可要考虑在 BufferedReader内包装 InputStreamReader
			   BufferedReader bufr = new BufferedReader(isr);
			   
			   
			   //4.创建将数据写入到文本文件的文件输出流
			   FileOutputStream fos = new FileOutputStream("D:\\projects\\testWeb\\src\\zmx\\io\\test\\02.txt"); 
			   
			   //5.为FileOutputStream加上字符处理功能
			   OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8"); 
			   
			   //6.为了获得最高效率，可考虑将 OutputStreamWriter 包装到 BufferedWriter 中，以避免频繁调用转换器
			   BufferedWriter bufw = new BufferedWriter(osw);
			   
			  
			   /*
			   String data = null;
			   while((data =bufr.readLine()) != null){				  
				  bufw.write(data);
			   }*/
			   
			   
			   // 以字符方式显示文件内容 
			   int ch = 0;
			   while((ch = bufr.read()) != -1) {
			    System.out.print((char)ch+"|"); 
			    osw.write(ch); 
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
