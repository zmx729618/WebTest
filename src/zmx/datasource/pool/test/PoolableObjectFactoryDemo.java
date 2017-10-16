package zmx.datasource.pool.test;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.pool.PoolableObjectFactory;

/**
 * 一个简单的对象池工厂
 * @author zhangwenchao
 *
 */
public class PoolableObjectFactoryDemo implements PoolableObjectFactory{
	//产生整数的对象池工厂
	private static AtomicInteger counter = new AtomicInteger(0);

	@Override
	public void activateObject(Object arg0) throws Exception {
		System.out.println("Before borrow:" + arg0); //在取出之前被调用
	}

	@Override
	public void destroyObject(Object arg0) throws Exception {		
		System.out.println(" Destroying object:" + arg0); //在对象销毁的时候被调用	
	}

	@Override
	public Object makeObject() throws Exception { //创建对象
		Object obj = String.valueOf(counter.getAndIncrement());
		System.out.println("Creat object "+obj);
		return obj;

	}

	@Override
	public void passivateObject(Object arg0) throws Exception {
		System.out.println("Return object"+arg0);
	}

	@Override
	public boolean validateObject(Object arg0) {
		return true;
	}
	
	
	
	

}
