package jvm.project.test;


public class ByteUtils {

	
	/**
	 * byte
	 * @param b
	 * @param start
	 * @param len
	 * @return
	 */
	public static int byte2Int(byte[] b, int start, int len) {
		
		int sum = 0;
		int end = start + len;
		for(int i=start; i<end; i++ ){
			int n = ((int)b[i]) & 0xff;
			n <<=(--len)*8;
			sum = n+sum;
		}
		return sum;
	}
	
	/**
	 * int按照高位在前地位在后的顺序转化为byte数组。
	 * @param value
	 * @param len
	 * @return
	 */
	public static byte[] int2byte(int value, int len){
		byte[] b = new byte[len];	
		for(int i=0; i<len; i++){	
			b[len-i-1] = (byte)((value >> 8*i) & 0xff);
		}
		return b;
	}
	
	public static String byte2String(byte[] b,int start,int len){
		return new String(b,start,len);
	}
	
	
	public static byte[] string2Bytes(String str){
		return str.getBytes();
	}
	
	
	public static byte[] bytesReplace(byte[] originalBytes, int offset, int len, byte[] replaceBytes){
		
		byte[] newBytes = new byte[originalBytes.length + (replaceBytes.length-len)];
		
		System.arraycopy(originalBytes, 0, newBytes, 0, offset);
		
		System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
		
		System.arraycopy(originalBytes, offset+len, newBytes, offset+replaceBytes.length, originalBytes.length-offset-len);
	
		return newBytes;
	}
	
	
	public static void main(String[] args) {
		
		byte[] b = new byte[]{67,78};
		int j = ByteUtils.byte2Int(b, 0, 2);
		System.out.println(j);
		
		byte[] bytes = ByteUtils.int2byte(17230, 2);
		for(int i=0;  i < bytes.length; i++){
			System.out.println(bytes[i]);
		}
		
		
		String str = ByteUtils.byte2String(b, 0, b.length);
		
		System.out.println(str);
		
		byte[] bytes2 = ByteUtils.string2Bytes("CNcn");
		
		for(int i=0;  i < bytes2.length; i++){
			System.out.println(bytes2[i]);
		}
		
		
	}

}
