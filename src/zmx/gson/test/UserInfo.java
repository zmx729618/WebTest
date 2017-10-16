package zmx.gson.test;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable{

	private static final long serialVersionUID = -7371753338546349542L;
	
    private String id;  
    
    private String username; 
    
    private String face;
    
    private Date birthday;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
    
    
    

	
	
	
	

}
