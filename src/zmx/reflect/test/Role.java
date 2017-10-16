package zmx.reflect.test;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(schema = "public")
public class Role extends AbsEntity implements IEntity{
    
	public String roleName;

	public String userId;

	public List<User> children;

	private RoleType roleType = RoleType.Manager;

	private User user;

	public Role() {}

	

	private Role(String roleName) {

		this.roleName = roleName;

	}

	public String getRoleName() {

		return

		roleName;

	}

	public void setRoleName(String roleName) {

		this.roleName = roleName;

	}

	public String getUserId() {

		return

		userId;

	}

	public void setUserId(String userId) {

		this.userId = userId;

	}

	public String getDisplayString() {

		System.out.println("I am a Role");

		return

		"Role";

	}

}
