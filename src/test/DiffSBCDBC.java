package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiffSBCDBC {
	
    public static String fullWidth2halfWidth(String fullWidthStr) {
        if (null == fullWidthStr || fullWidthStr.length() <= 0) {
            return "";
        }
        char[] charArray = fullWidthStr.toCharArray();
        //对全角字符转换的char数组遍历
        for (int i = 0; i < charArray.length; ++i) {
            int charIntValue = (int) charArray[i];
            //如果符合转换关系,将对应下标之间减掉偏移量65248;如果是空格的话,直接做转换
            if (charIntValue >= 65281 && charIntValue <= 65374) {
                charArray[i] = (char) (charIntValue - 65248);
            } else if (charIntValue == 12288) {
                charArray[i] = (char) 32;
            }
        }
        return new String(charArray);
    }
	
	public static void main(String[] args) {
	      String str= "我是老师";
		  System.err.println(DiffSBCDBC.fullWidth2halfWidth(str)) ;
		  
		  Pattern p = Pattern.compile("a*b");    
		  Matcher m = p.matcher("aaaab");    
		  boolean b = m.matches(); 
		  System.out.println(b);
	}

}
