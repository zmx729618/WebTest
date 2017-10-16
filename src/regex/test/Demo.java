package regex.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
	
	public static void main(String[] args) {
		

	//	String regEx = "<a>([\\s\\S]*?)</a>";		
	//	String s = "<a>123</a><a>456</a><a>789</a>";
		/**
		 * 正则表达式中的（）代表一个分组，序号从1开始，获取第i个分组的数据使用mat.group(i)
		 * 正则表达式默认使用贪婪匹配原则-最大匹配；后面加一个？使用非贪婪原则-最小匹配
		 */
		String s = "<a href=\"/history7450\" title=\"1062年——北宋清官包拯逝世\">1062年——北宋清官包拯逝世</a>";
		String regEx = "<a href=\"(.*?)\"";
		String ss= getPatternAloneString(s, regEx);
		System.out.println(Arrays.asList(ss));
  
	}

	/**
	 * 
	 * @param s
	 * @param regEx
	 * @return
	 */
	public static String[] getPatternString(String s, String regEx) {
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(s);
		List<String> list = new ArrayList<String>();
		while(mat.find()){	
			for(int i=1; i<=mat.groupCount(); i++){
				  list.add(mat.group(i));	   
				}
		}
		String[] ss = new String[list.size()];
		return list.toArray(ss);
	}
	
	public static String getPatternAloneString(String s, String regEx) {
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(s);
		if(mat.find()){	
			return mat.group(1);		
		}		
		return null;
	}

}
