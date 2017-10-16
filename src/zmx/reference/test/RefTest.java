package zmx.reference.test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class RefTest {
	
	public static void main(String[] args) {
		
	
		ObjectRef aRef = new ObjectRef(); //强引用对象
		ReferenceQueue<ObjectRef> queue =  new ReferenceQueue<ObjectRef>(); //引用队列
		SoftReference<ObjectRef> aSoftRef = new SoftReference<ObjectRef>(aRef, queue); //创建一个软引用，并关联一个引用队列
	    aRef  =  null; //断开强引用 
	    ObjectRef  anotherRef =(ObjectRef)aSoftRef.get(); //使用软引用获取对象，如果对象没有被垃圾回收返回该对象；如果该对象被垃圾回收器回收返回null
	    SoftReference<ObjectRef> ref = null ;
	    while((ref=(SoftReference<ObjectRef>)queue.poll())!=null){
	      // 清除 ref
	    }
	    
	    
	    System.out.println(anotherRef);
	    System.out.println(aSoftRef);
	    
	}

}
