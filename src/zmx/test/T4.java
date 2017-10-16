package zmx.test;

import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class T4 {
	
	public static void main(String[] args) throws Exception {
		/*String ss = "您"; 
		byte[] strBytes = ss.getBytes("gbk"); 
		System.out.println(strBytes.length);*/
		
		
       /* int[] array1 = new int [120];  
        for (int i = 0; i < array1.length; i++) {  
            array1 [i] = i;  
        }  
        int[] array2 = new int [100];  
        System.arraycopy(array1, 0, array2, 0, 100);  
        for (int i = 0; i < array2.length; i++) {  
            System.out.println(array1 [i]);
        }*/
        
       // System.out.println("sdfsadfsdf".indexOf('s', 0)); 
        
        /*StringTokenizer stringTokenizer = new StringTokenizer("sdf,sadf,sdf",",");
        
       while( stringTokenizer.hasMoreTokens()){
    	   System.out.println(stringTokenizer.nextToken());
       }*/
		
		 /*AtomicBoolean lock = new AtomicBoolean(true);  
		 lock.compareAndSet(true, false);  
		 */
		/*String srcstring="this is a about split test";  
	    String stringarray[]=srcstring.split("\\s");  
		//// 在每个空格字符处进行分解  
		for(String stemp:stringarray){  
		    System.out.println(stemp);  
		}*/
		
		
		
		/*String srcstring1=" this  is a about split  test";//有n个空格的话，分成的数组长度为n+1  
		//如果字符串中有多个空格时，则两个空格间认为是没有字符，结果字符串数组中该位置为空。  
		String stringarray1[]=srcstring1.split(" "); 
		System.out.println("legth:"+stringarray1.length);
		for(String stemp:stringarray1){  
		    System.out.println(stemp);  
		} */

		/*String ipstring="59.64.159.224";  
		String iparray[]=ipstring.split("\\.");  
		for(String stemp:iparray){  
			System.out.println(stemp);  
		}  */

		   /*Pattern pattern = Pattern.compile("^Java.*");
		   Matcher matcher = pattern.matcher("Java 不是人");
		   boolean b= matcher.matches();
		   // 当条件满足时，将返回 true ，否则返回 false
		   System.out.println(b);*/
		
		
		   /*Pattern pattern = Pattern.compile("[, |]+");
		   String[] strs = pattern.split("Java Hello World  Java,Hello,,World|Sun");
		   for (int i=0;i<strs.length;i++) {
		       System.out.println(strs[i]);
		   } */
		
		/*Pattern pattern = Pattern.compile(" 正则表达式 ");
		Matcher matcher = pattern.matcher(" 正则表达式 ,Hello World, 正则表达式 ,Hello World");
		 // 替换第一个符合正则的数据 
		System.out.println(matcher.replaceAll("Java"));*/
		
		/*Pattern pattern = Pattern.compile(" 正则表达式 ");
		Matcher matcher = pattern.matcher(" 正则表达式 Hello World, 正则表达式 Hello World ");
		 StringBuffer sbr = new StringBuffer();
		 while (matcher.find()) {
		     matcher.appendReplacement(sbr, "Java");
		 }
		 matcher.appendTail(sbr);
		 System.out.println(sbr.toString());*/
		
		/*Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
		 Matcher matcher = pattern.matcher("<a href=\"index.html\"> 主页 </a>");
		 String string = matcher.replaceAll("");
		 System.out.println(string);*/
		
		
		 /*Pattern pattern = Pattern.compile("href=\"(.+?)\"");
		 Matcher matcher = pattern.matcher("<a href=\"index.html\"> 主页 </a>");
		 if(matcher.find()){
		   System.out.println(matcher.group(1));
		 }*/
		
		Pattern pattern = Pattern.compile("(http://|https://){1}[\\w\\.\\-/:]+");
		Matcher matcher = pattern.matcher("dsdsds<http://dsds//gfg-f/fdfd:8080/>fdf");
		StringBuffer buffer = new StringBuffer();
		while(matcher.find()){              
		     buffer.append(matcher.group());        
		     buffer.append("\r\n");              
		     System.out.println(buffer.toString());
		 }
		
		
		
		
		
		
		
		
		
		
       
	}

}
