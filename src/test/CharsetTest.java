package test;

import java.nio.charset.Charset;
import java.util.Arrays;

public class CharsetTest {
	
	public static void main(String[] args) {
		
		Charset iso8859_1 = Charset.forName("iso-8859-1"); //单字节编码字符集
		Charset big5 = Charset.forName("big5"); //双字节编码字符集
		Charset utf8 = Charset.forName("utf-8"); //可变长编码字符集
		
		String str = "测试";
		
		byte[] bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes));
		
		String iso8859Str = new String(bytes, iso8859_1);
		
		System.out.println(iso8859Str + "  and length:" + iso8859Str.length());
		
		byte[] resumeBytes  = iso8859Str.getBytes(iso8859_1);
		
		System.out.println(new String(resumeBytes,utf8));
		
		
		String big5Str = new String(bytes, big5);
		
		System.out.println(big5Str + "  and length:" + big5Str.length());
		
		byte[] resumeBytes2  = big5Str.getBytes(iso8859_1);
		
		System.out.println(new String(resumeBytes2,utf8));
		
		
		String utf8Str = new String(bytes, utf8);
		System.out.println(utf8Str + "  and length:" + utf8Str.length());
		
		
		
		
		
		
		
		
		
		
	}

}
