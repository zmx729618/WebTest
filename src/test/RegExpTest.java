package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest {
	
	
	public  static  boolean  checkAll(String reg, String str){
		
		Pattern pattern =  Pattern.compile(reg);  //将给定的正则表达式编译到模式；
		
		Matcher matcher = pattern.matcher(str);  //创建匹配给定输入与此模式的匹配器
		
		boolean result = matcher.matches();  //尝试将整个区域与模式匹配
		
		return result; 
		
	}
	
	
	public  static  boolean  checkFirst(String reg, String str){
		
		Pattern pattern =  Pattern.compile(reg);  //将给定的正则表达式编译到模式；
		
		Matcher matcher = pattern.matcher(str);  //创建匹配给定输入与此模式的匹配器
		
		boolean result = matcher.find();  //尝试将整个区域与模式匹配
		
		return result; 
		
	}
	
	
	
	
	public static List<String> findAll(String reg, String str){
		
		Pattern pattern =  Pattern.compile(reg);  //将给定的正则表达式编译到模式；
		
		Matcher matcher = pattern.matcher(str);  //创建匹配给定输入与此模式的匹配器
		
		List<String>  strList = new ArrayList<String>();
		
		while (matcher.find()) {	
			
			strList.add(matcher.group());		
			
		}
		
		return strList;
		

	}
	
	
	public static void main(String[] args) {
		
		String regex = "b[ei]{2}";
		
		String str = "welcome to beijing, beijing huan ying ni bee";
		
		System.out.println(RegExpTest.checkAll(regex, str));    // 全字符串匹配
		
		System.out.println(RegExpTest.checkFirst(regex, str));  // 部分字符串匹配
		
		List<String> arrayStr = RegExpTest.findAll(regex, str); // 返回所有匹配到的字符串
		
		System.out.println(arrayStr);
		
		Calendar c1 = new GregorianCalendar(2015,3,20);
	    Date d1 = c1.getTime();
	    
		Calendar c2 = new GregorianCalendar(2016,1,8);
		Date d2 = c2.getTime();
		
		System.out.println(d1);
		System.out.println(d2);
		long times = d2.getTime()-d1.getTime();
		System.out.println(times);
		int days = (int)(times/(3600*24*1000));
		
		System.out.println(days);
	}

}
