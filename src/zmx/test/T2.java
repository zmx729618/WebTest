package zmx.test;

import java.util.Calendar;
import java.util.UUID;

public class T2 {
	
	static{
		System.out.println("静态初始化块执行了");
	}
	
	 public static String getHello() {

	        return "hello";

	    } 
	public static void main(String[] args) {
		
		//System.out.println(UUID.randomUUID().toString());
		
	       /*String a = "hello2";  

	        final String b = "hello";

	        String d = "hello";

	        String c = b + 2;  

	        String e = d + 2;

	        System.out.println((a == c));

	        System.out.println((a == e));*/
		
		/*String a = "hello2";  

        final String b = getHello();

        String c = b + 2;  

        System.out.println((a == c));*/
		
		
		Calendar cal = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。   
		cal.add(Calendar.DAY_OF_MONTH, -1);//取当前日期的前一天.   
		//cal.add(Calendar.DAY_OF_MONTH, +1);//取当前日期的后一天.   
		//通过格式化输出日期   
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");   
		System.out.println("Today is:"+format.format(Calendar.getInstance().getTime()));   
		System.out.println("yesterday is:"+format.format(cal.getTime())); 

		
		
	}
	

}
