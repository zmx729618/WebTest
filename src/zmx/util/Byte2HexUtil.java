package zmx.util;

import java.math.BigInteger;
/**
 * 
 * @author zhangwenchao
 *
 */
public class Byte2HexUtil {
	
	    public static String bytes2hex01(byte[] bytes)  
	    {  
	        /** 
	         * 第一个参数的解释，记得一定要设置为1 
	         *  signum of the number (-1 for negative, 0 for zero, 1 for positive). 
	         */  
	        BigInteger bigInteger = new BigInteger(1, bytes);  
	        return bigInteger.toString(16);  
	    } 
	    
	    
	    /**
	     * 方式二
	     * 
	     * @param bytes
	     * @return
	     */
	    public static String bytes2hex02(byte[] bytes)
	    {
	        StringBuilder sb = new StringBuilder();
	        String tmp = null;
	        for (byte b : bytes)
	        {
	            // 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
	            tmp = Integer.toHexString(0xFF & b);
	            if (tmp.length() == 1)// 每个字节8位，转为16进制标志，2个16进制位
	            {
	                tmp = "0" + tmp;
	            }
	            sb.append(tmp);
	        }
	 
	        return sb.toString();
	 
	    }
	    
	    /**
	     * 方式三
	     * 
	     * @param bytes
	     * @return
	     */
	    public static String bytes2hex03(byte[] bytes)
	    {
	        final String HEX = "0123456789abcdef";
	        StringBuilder sb = new StringBuilder(bytes.length * 2);
	        for (byte b : bytes)
	        {
	            // 取出这个字节的高4位，然后与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
	            sb.append(HEX.charAt((b >> 4) & 0x0f));
	            // 取出这个字节的低位，与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
	            sb.append(HEX.charAt(b & 0x0f));
	        }
	 
	        return sb.toString();
	    }
	    
	    public static void main(String[] args) {
			byte[] bytes = {10,23,24,54};
			System.out.println(Byte2HexUtil.bytes2hex01(bytes));
		    System.out.println(Byte2HexUtil.bytes2hex02(bytes));
		    System.out.println(Byte2HexUtil.bytes2hex03(bytes));
			
		}
	    


}
