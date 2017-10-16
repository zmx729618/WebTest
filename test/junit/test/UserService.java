package junit.test;

public interface UserService {
	
	public User findUserByUserName();
	
	public boolean hasMatchUser(int id, String name);
	
	public void registerUser(User u);
	
	

}
