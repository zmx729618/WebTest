package zmx.chinese.length;

public class ChineseUtils {
	
	/** 
     * 获取字符串的长度，中文占一个字符,英文数字占半个字符 
     * 
     * @param value  指定的字符串           
     * @return 字符串的长度 
     */  
    public static double length(String value) {  
        double valueLength = 0;  
        String chinese = "[\u4e00-\u9fa5]";  
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1  
        for (int i = 0; i < value.length(); i++) {  
            // 获取一个字符  
            String temp = value.substring(i, i + 1);  
            // 判断是否为中文字符  
            if (temp.matches(chinese)) {  
                // 中文字符长度为1  
                valueLength += 1;  
            } else {  
                // 其他字符长度为0.5  
                valueLength += 0.5;  
            }  
        }  
        //进位取整  
        return  Math.ceil(valueLength); 
        
    }
    
    /**
     * 截取包含中文字符串
     * @param str
     * @param byteLength
     * @return
     * @throws Exception
     */
    public static String splitString(String str, int byteLength)  
            throws Exception {  
        //如果字符串为空，直接返回   
        if(str == null || "".equals(str)) {  
            return str;  
        }  
        //用于统计这个字符串中有几个中文字符   
        int wordCount = 0;  
        //统一按照gbk编码来得到他的字节数组，因为不同的编码字节数组是不一样的。   
        byte[] strBytes = str.getBytes("GBK");  
          
        //如果只截取一位，而且第一位是中文字符时的处理   
        if (byteLength == 1) {  
            if (strBytes[0] < 0) {  
                return str.substring(0, 1);  
            }  
        }  
        //字符串中的一个中文会使得wordCount 加两次   
        //如果你这个字节取出来的是一个汉字也就是两个字节当中的一个的话val的值为负数   
        for (int i = 0; i < byteLength; i++) {  
            int val = strBytes[i];  
            if (val < 0) {  
                wordCount++;  
            }  
        }  
          
        //如果传递的这个截取的位数没有截到半个中文上面，那么就按照byteLength - (wordCount / 2个长度进行截取   
        if (wordCount % 2 == 0) {  
            return str.substring(0, (byteLength - (wordCount / 2)));  
        }  
        //否则，我们就舍弃多出来的这一位 所以  -1    
        return str.substring(0, (byteLength - (wordCount / 2) - 1));  
  
    }  

    
    
    
    
    
    
   
    public static void main(String[] args) throws Exception {
		String value = "快递费ww";
		double len =  ChineseUtils.length(value);
		System.out.println(len);
		
		//java API
		System.out.println(value.length());
		
		String result = ChineseUtils.splitString(value, 4);
		System.out.println(result);
		
		
		//java API 
		System.out.println(value.substring(0, 4));
		
	}

}
