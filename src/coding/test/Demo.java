package coding.test;


public class Demo {
	
	
	public static String getMainMenu() {  
	    StringBuffer buffer = new StringBuffer();  
	    buffer.append("您好，我是小q，请回复数字选择服务：").append("\n\n");  
	    buffer.append("1  天气预报").append("\n");  
	    buffer.append("2  公交查询").append("\n");  
	    buffer.append("3  周边搜索").append("\n");  
	    buffer.append("4  歌曲点播").append("\n");  
	    buffer.append("5  经典游戏").append("\n");  
	    buffer.append("6  美女电台").append("\n");  
	    buffer.append("7  人脸识别").append("\n");  
	    buffer.append("8  聊天唠嗑").append("\n\n");  
	    buffer.append("回复“?”显示此帮助菜单");  
	    return buffer.toString();  
	} 
	
	/**
	 * emoji表情
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {  
	    return String.valueOf(Character.toChars(hexEmoji));  
	}  

	
	
	public static void main(String[] args) throws Exception {
		
	    // 运行结果：3   
	    System.out.println("张文超".getBytes("ISO8859-1").length);  
	    // 运行结果：6   
	    System.out.println("张文超".getBytes("GB2312").length);  
	    // 运行结果：6   
	    System.out.println("张文超".getBytes("GBK").length);  
	    // 运行结果：9   
	    System.out.println("张文超".getBytes("UTF-8").length);   
	     char[] chars =  Character.toChars(0x1F6B9);
	    for(char c : chars){
	    	System.out.println((byte)c);
	    }
	    System.out.println(String.valueOf(Character.toChars(0x1F6B9)));
	    System.out.println(emoji(0x1F6B2));
		
	}

}
