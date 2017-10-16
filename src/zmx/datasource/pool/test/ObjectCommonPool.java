package zmx.datasource.pool.test;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;

/**
 * 
 * @author zhangwenchao
 *
 */
public class ObjectCommonPool {
	
	static PoolableObjectFactory objFactory = new PoolableObjectFactoryDemo();
	static ObjectPool pool = new GenericObjectPool(objFactory);
	private static AtomicInteger endcount = new AtomicInteger(0);
	
	public static class PoolThread extends Thread{
		public void run(){
			Object obj = null;
			try{
				for(int i=0;i<100;i++){
					System.out.println("== "+i+" ==");
					obj = pool.borrowObject(); //从池中获取对象
					System.out.println(obj+" is get"); //模拟使用对象
					pool.returnObject(obj);   //使用完成后，对象返回池中
				 }
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				endcount.getAndIncrement();
			}
		}
	}
	
	
	
	
    public static void main(String[] args) {
    	new PoolThread().start();
    	new PoolThread().start();
    	new PoolThread().start();
    	try {
			while(true){
				if(endcount.get()==3){
					pool.close();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		
	}

}
