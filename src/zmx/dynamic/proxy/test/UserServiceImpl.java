package zmx.dynamic.proxy.test;

public class UserServiceImpl implements UserService{

	@Override
	public void add() {
		 System.out.println("--------------------add---------------");  	
	}

	@Override
	public boolean delete() {
		System.out.println("--------------------delete---------------"); 
		return true;
	}

}
