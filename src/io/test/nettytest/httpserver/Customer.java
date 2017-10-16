package io.test.nettytest.httpserver;

import java.util.List;

public class Customer {
	
	private long custommerNumber;
	
	private String firstname;
	
	private String lastName;
	
	private List<String> middleNames;

	public long getCustommerNumber() {
		return custommerNumber;
	}

	public void setCustommerNumber(long custommerNumber) {
		this.custommerNumber = custommerNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<String> getMiddleNames() {
		return middleNames;
	}

	public void setMiddleNames(List<String> middleNames) {
		this.middleNames = middleNames;
	}
	
    
}
