package junit.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitTestCase {
	
    
	@Test
	public void test() {
		assertEquals(0, 0);
	}
	
	/**
	 * 异常测试---如果抛出该异常说明测试通过
	 */
	@Test(expected=NullPointerException.class)
	public void testException(){
		throw new NullPointerException();
	}
	
	
	
	/**
	 * 超时测试---如果方法运行时间少于1000毫秒测试通过 
	 */
	@Test(timeout=1000)
	public void testTimeOut(){
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
