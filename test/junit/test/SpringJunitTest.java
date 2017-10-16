package junit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import spring.source.test.MyBeanTest;

@RunWith(SpringJUnit4ClassRunner.class)  //用于配置spring中测试的环境 
@ContextConfiguration(locations="classpath:applicationContext.xml")  //用于指定配置文件所在的位置 
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)  //defaultRollback=true恢复数据库现场
public class SpringJunitTest {
	@Resource(name="myBeanTest")
	private MyBeanTest beanTest;
	
	
	//使用mock方法对接口和类进行模拟
	private UserServiceImpl mockUserService = mock(UserServiceImpl.class);
	
	@Test
	public void test(){
		Assert.assertEquals("testStr", beanTest.getTestStr());
	}
	
	@Test
	public void testMockInterface(){
		
		/**
		 * 使用下面语句对方法结果进行设定
		 */
		when(mockUserService.findUserByUserName()).thenReturn(new User(1,"Tom"));
		
		doReturn(true).when(mockUserService).hasMatchUser(1,"Tom");
		
		User u=new User(2, "lucy");
		doNothing().when(mockUserService).registerUser(u);
		
		/**
		 * 设定之后执行方法调用
		 */
		User user = mockUserService.findUserByUserName();		
		assertEquals("Tom",user.getName());
		
		
		boolean isMatch = mockUserService.hasMatchUser(1, "Tom");		
		assertEquals(true,isMatch);


		
	}

}
