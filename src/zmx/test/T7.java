package zmx.test;

import java.util.Vector;

public class T7 {
	
	public static void main(String[] args) throws Exception {
		
		String encoding = System.getProperty("file.encoding"); 
		System.out.println(encoding); 
		
		byte[] b_gbk = "中".getBytes("GBK"); 
		System.out.println(b_gbk.length); 
		byte[] b_utf8 = "中".getBytes("UTF-8");
		System.out.println(b_utf8.length);
		byte[] b_iso88591 = "中".getBytes("ISO8859-1"); 
		System.out.println(b_iso88591.length);
		
		Vector vector = new Vector<Integer>(5, 5);
		
		System.out.println("a(Unicode)    ：" + "a".getBytes("Unicode").length);  
		System.out.println("aa(Unicode)    ：" + "aa".getBytes("Unicode").length);  
		System.out.println("啊(Unicode)   ：" + "啊".getBytes("Unicode").length);  
		System.out.println("啊啊(Unicode) ：" + "啊啊".getBytes("Unicode").length);  
		System.out.println("");  
		System.out.println("a(UTF-8)    ：" + "a".getBytes("UTF-8").length);  
		System.out.println("aa(UTF-8)   ：" + "aa".getBytes("UTF-8").length);  
		System.out.println("啊(UTF-8)   ：" + "啊".getBytes("UTF-8").length);  
		System.out.println("啊啊(UTF-8) ：" + "啊啊".getBytes("UTF-8").length);  
		System.out.println("");  
		System.out.println("a(UTF-16)    ：" + "a".getBytes("UTF-16").length);  
		System.out.println("aa(UTF-16)   ：" + "aa".getBytes("UTF-16").length);  
		System.out.println("啊(UTF-16)   ：" + "啊".getBytes("UTF-16").length);  
		System.out.println("啊啊(UTF-16) ：" + "啊啊".getBytes("UTF-16").length);

		
	}

}
