package io.test.nettytest.jbossmarshalling;

import java.io.Serializable;

public class SubscribeReq implements Serializable {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 8655946682723691922L;
	
	
	private int subReqID;
	
	private String username;
	
	private String productName;
	
	private String phoneNumber;
	
	private String address;
	
	public SubscribeReq() {
		super();
	}
	
	
	public SubscribeReq(int subReqID, String username, String productName,
			String phoneNumber, String address) {
		this.subReqID = subReqID;
		this.username = username;
		this.productName = productName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public int getSubReqID() {
		return subReqID;
	}

	public void setSubReqID(int subReqID) {
		this.subReqID = subReqID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubscribeReq [subReqID=" + subReqID + ", username=" + username
				+ ", productName=" + productName + ", phoneNumber="
				+ phoneNumber + ", address=" + address + "]";
	}
	
	


	
	
	

}
