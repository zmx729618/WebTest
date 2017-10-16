package zmx.test;

import java.net.URLEncoder;



public class T5 {
	
	public static void main(String[] args) throws Exception {
		
		String fileName = "http://blog.csdn.net/z69183787/article/details?key=文章&words=世界  您好 ！";
		String returnFileName = URLEncoder.encode(fileName, "UTF-8"); 
		returnFileName = returnFileName.replace("+", "%20");  //encode后替换  解决空格问题

		
		returnFileName = new String(fileName.getBytes("GB2312"), "ISO8859-1"); 
        returnFileName = returnFileName.replace(" ", "%20"); 
		System.out.println(returnFileName);
       
	}

}
