package zmx.reflect.test;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users", schema = "public")
public class User {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	@Column(length = 40)
	@AccessType("property")
	private String id;

	private String loginName;

	private String password;

	private String address;

	@ManyToOne
	private Role role;

	public String getId() {

		return

		id;

	}

	protected void setId(String id) {

		this.id = id;

	}

	public String getLoginName() {

		return

		loginName;

	}

	public void setLoginName(String loginName) {

		this.loginName = loginName;

	}

	public String getPassword() {

		return

		password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public String getAddress() {

		return

		address;

	}

	public void setAddress(String address) {

		this.address = address;

	}

	public Role getRole() {

		return

		role;

	}

	public void setRole(Role role) {

		this.role = role;

	}

}
