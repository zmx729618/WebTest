package org.zwc.testweb.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="t_user")
public class User extends BaseIdEntity{

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = -7732600054349826969L;
	
	private String name;
	
	private String password;
	
	@Enumerated(EnumType.ORDINAL)
	private UserType userType=UserType.NORMAL;
	
	private int locked;   // 0 ：未锁定，1：已锁定
	
	private int credit;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}  
	
	
	
	
	

}
