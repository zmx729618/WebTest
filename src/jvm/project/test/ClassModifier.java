package jvm.project.test;

public class ClassModifier {
	
	
	/**
	 * class文件常量池的起始偏移地址
	 */
	private static final int CONSTANT_POOL_COUNT_INDEX = 8;
	
	
	/**
	 * CONSTANT_UTF8_INFO常量的tag标志
	 */
	private static final int CONSTANT_UTF8_info = 1;
	
	/**
	 * 常量池中11种常量所占的长度，CONSTANT_UTF8_info型除外，因为它是不定长的
	 * 
	 */
	
	private static final int[] CONSTANT_ITEM_LENGTH={-1,-1,5,-1,5,9,9,3,3,5,5,5,5};
	
	private static final int u1=1;
	
	private static final int u2=2;
	
	private byte[] classByte;
	
	public ClassModifier(byte[] classByte){
		this.classByte = classByte;
	}
	/**
	 * 修改常量池中 CONSTANT_UTF8_info常量的内容
	 * @author zhangwenchao
	 * @param oldStr 修改前的字符串
	 * @param newStr 修改后的字符串
	 * @return 修改结果
	 */
	public byte[] modifyUTF8Constant(String oldStr, String newStr){
		int cpc = getConstantPoolCount();  //获取常量池中常量的个数；
		
		int offset = CONSTANT_POOL_COUNT_INDEX +2;  //常量定义偏移量；
		
		for(int i=0; i<cpc; i++){
			
			int tag = ByteUtils.byte2Int(classByte, offset, u1);  //获取一个字节并转化为int类型
			if(tag == CONSTANT_UTF8_info ){  //tag=1为 CONSTANT_UTF8_info类型常量
				
				int len =  ByteUtils.byte2Int(classByte, offset+u1, u2);  //得到常量的长度。
				offset +=(u1+u2);
				String str = ByteUtils.byte2String(classByte, offset, len);
				if(str.equalsIgnoreCase(oldStr)){
					
					byte[] strBytes =  ByteUtils.string2Bytes(newStr);
					byte[] strLen = ByteUtils.int2byte(newStr.length(), u2);
					classByte = ByteUtils.bytesReplace(classByte, offset-u2, u2, strLen);
					classByte = ByteUtils.bytesReplace(classByte, offset, len, strBytes);
					return classByte;
				}else{
					offset +=len;
				}
				
			}else{
				
				offset += CONSTANT_ITEM_LENGTH[tag];
				
			}
			
		}
		
		return classByte;
		
	}
	
	/**
	 * 获取常量池中常量的数量
	 * @author zhangwenchao
	 * @return 常量池中常量的数量
	 */
	private int getConstantPoolCount() {
		
		
		return  ByteUtils.byte2Int(classByte,CONSTANT_POOL_COUNT_INDEX,u2);
		
	}
	
	

}
