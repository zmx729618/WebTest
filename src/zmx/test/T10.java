package zmx.test;

import zmx.util.Byte2HexUtil;



public class T10 {
	
	public static void print(byte[] bytes) throws Exception{
		for(byte b: bytes){
			System.out.print(b+" "+ new String(new byte[]{b},"ISO8859-1")+"     ");
		}
		System.out.println();
	}
	
	public static void print(String str) throws Exception{
		for(int i=0;i<str.length();i++){
			System.out.print(str.charAt(i)+" "+ ((byte)str.charAt(i))+"     ");
		}
		System.out.println();
	}
	
   public static void main(String[] args) throws Exception {
	   
		String chinese = "abc中文";  //中文字符串
		
/*		byte[] unicodes =  chinese.getBytes("UNICODE");
		System.out.println(unicodes.length);
		print(unicodes);
		System.out.println(Byte2HexUtil.bytes2hex03(unicodes));*/
		
		byte[] bg2312 = chinese.getBytes("GB2312"); //根据某一中文编码(ASCall和ISO8859-1不包含中文)获取字节数组
		System.out.println(bg2312.length); //不同的中文格式编码获取的字节数组长度不同。
		print(bg2312);
		String sender = new String(bg2312,"ISO8859-1");
		System.out.println("发送的数据:"+sender); //将该字节数组根据ISO8859-1转换为网络可传输的形式
		System.out.println(Byte2HexUtil.bytes2hex03(bg2312)); //本质上就是传输编码之后的字节数组
		
		String receive = sender;  //接受的数据
		System.out.println("接收的数据:"+receive);
		print(receive);
		byte[] receiveBytes = sender.getBytes("ISO8859-1");
		
		System.out.println(Byte2HexUtil.bytes2hex03(receiveBytes));
		
		System.out.println(new String(receiveBytes,"GB2312"));
		System.out.println(new String(receiveBytes,"GB2312").length());
	
   }

}
