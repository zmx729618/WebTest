package junit.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class MockitoSampleTest {
	
	
	//使用mock方法对接口和类进行模拟
	private UserService mockUserService =  mock(UserService.class);
	
	
	private UserServiceImpl mockUserServiceImpl = mock(UserServiceImpl.class);
	
	
	//使用注解对类进行模拟
	@Mock
	private User mockUser;
	
	
	//需要使用下面方法对注解的模拟类进行初始化
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
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
		
		
		when(mockUser.getId()).thenReturn(2);
		when(mockUser.getName()).thenReturn("lucy");
		
		/**
		 * 设定之后执行方法调用
		 */
		User user = mockUserService.findUserByUserName();		
		assertEquals("Tom",user.getName());
		
		
		boolean isMatch = mockUserService.hasMatchUser(1, "Tom");		
		assertEquals(true,isMatch);

		assertNotNull(mockUser);
		assertEquals(2,mockUser.getId());
		assertEquals("lucy",mockUser.getName());
		
	}
	
	/**
	 * 模拟对实现进行测试
	 */
	
	@Test
	public void testMockInterfaceImpl(){
		
		/**
		 * 使用下面语句对方法结果进行设定
		 */
		when(mockUserServiceImpl.findUserByUserName()).thenReturn(new User(1,"Tom"));
		
		doReturn(true).when(mockUserServiceImpl).hasMatchUser(1,"Tom");
		
		User u=new User(2, "lucy");
		doNothing().when(mockUserServiceImpl).registerUser(u);
		
		
		when(mockUser.getId()).thenReturn(2);
		when(mockUser.getName()).thenReturn("lucy");
		
		/**
		 * 设定之后执行方法调用
		 */
		User user = mockUserServiceImpl.findUserByUserName();		
		assertEquals("Tom",user.getName());
		
		
		boolean isMatch = mockUserServiceImpl.hasMatchUser(1, "Tom");		
		assertEquals(true,isMatch);

		assertNotNull(mockUser);
		assertEquals(2,mockUser.getId());
		assertEquals("lucy",mockUser.getName());
		
	}
	

}
