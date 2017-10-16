package zmx.util;

import java.text.DecimalFormat;
/**
 * 0 
 * 保留小数位数的工具类
 * @author zhangwenchao
 *
 */
public class DecimalFormatUtil {
	
	
	public static String convertDoubleToDouble(String format,Double data){  
		        String result = "";  
		        if(data==null){  
		            result = "";  
		        }else{
		        	result=	new DecimalFormat("###,###.0##").format(data);
		        }  
		        return result;  
    } 

	
	public static void main(String[] args) {
		
		System.out.println(DecimalFormatUtil.convertDoubleToDouble("###,###.0##",33333333333.010));  
		System.out.println(DecimalFormatUtil.convertDoubleToDouble("0.000",3.0)); 
		 

	}

}
