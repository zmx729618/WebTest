package md5.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * 使用MD5加密会生成加密后的byte，直接转化为string会出现乱码字符，可以是用base64或者自定义算法转化
 * 
 * @author zhangwenchao
 *
 */
public class MD5Util {
	
	  protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',  '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };  
      protected static MessageDigest messagedigest = null;
      
      static{
          try{
              messagedigest = MessageDigest.getInstance("MD5");   
          } catch (NoSuchAlgorithmException e) {  
              System.err.println("MD5FileUtil messagedigest初始化失败");  
              e.printStackTrace();
          }  
      }
      
      /**
       * 对文件进行MD5加密
       * 
       * @author zhangwenchao
       */
      public static String getFileMD5String(File file) throws IOException {
              FileInputStream in = new FileInputStream(file);  
              FileChannel ch = in.getChannel();  
              MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());  
              messagedigest.update(byteBuffer);  
              return bufferToHex(messagedigest.digest());  
      }
      

      
      
      /**
       * 对字符串进行MD5加密
       * 
       * @author zhangwenchao
       */
      public static String getMD5String(String s) {
              return getMD5String(s.getBytes());  
      }
      
      /**
       * 对byte类型的数组进行MD5加密
       * @param bytes
       * @return
       */
      public static String getMD5String(byte[] bytes) {
          messagedigest.update(bytes);  
          return bufferToHex(messagedigest.digest());  
     }
      
      
      
      private static String bufferToHex(byte bytes[], int m, int n) {
          StringBuffer stringbuffer = new StringBuffer(2 * n);  
          int k = m + n;  
          for (int l = m; l < k; l++) {  
                  char c0 = hexDigits[(bytes[l] & 0xf0) >> 4];
                  char c1 = hexDigits[bytes[l] & 0xf];
                  stringbuffer.append(c0);  
                  stringbuffer.append(c1);  
          }  
          return stringbuffer.toString();  
     }

      
	 private static String bufferToHex(byte[] bytes) {
	          return bufferToHex(bytes, 0, bytes.length);  
	 }
	 
	 
    public static void main(String[] args) {
    	
    	String src = "跨世纪的浪费空间sdfsd";
    	messagedigest.update(src.getBytes());
    	
    	byte[] bytes =  messagedigest.digest();
    	System.out.println(bytes.length);
    	for(byte b : bytes){
    		System.out.print(b+" ");
    	}
    	System.out.println();
    	String des = bufferToHex(bytes);
    	System.out.println(des.getBytes().length);
    	System.out.println(des);
    	for(byte b : des.getBytes()){
    		System.out.print(b+" ");
    	}
	}
  


}
