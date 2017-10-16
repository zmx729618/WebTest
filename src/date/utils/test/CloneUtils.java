package date.utils.test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;



/**
 * 对象copy工具---根据序列化实现深拷贝
 * @author zhangwenchao
 *
 */
public class CloneUtils {
	
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj){
		
		//拷贝产生的对象
		T clonedObj = null;
		
		try{
			//初始化内存字节数组输出流 -用写入对象字节数据
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			//新建一个对象输出流
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			
			oos.writeObject(obj);  //将对象写到输出流
			
			oos.close();
			
			//初始化内存字节数组输入流-分配内存空间，读入原始对象,生成新对象
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			
			//新建一个对象输入流
			ObjectInputStream ois = new ObjectInputStream(bais);
			
			clonedObj = (T)ois.readObject();
			
			ois.close();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return clonedObj;
	}
	
	
	
	/**
	 * 数组扩容拷贝
	 * @param datas
	 * @param newLength
	 * @return
	 */
	public static <T> T[] expandCapacity(T[] datas, int newLength){
		
		newLength = newLength<0 ? 0 : newLength; 
		return Arrays.copyOf(datas, newLength);  // （浅拷贝）复制指定的数组，截取或用 null填充（如有必要），以使副本具有指定的长度
		
	}
	

}
