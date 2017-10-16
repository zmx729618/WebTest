package io.test.nettytest.subscribe;

import java.io.Serializable;

public class SubscribeResp implements Serializable {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = -5988453908599534162L;
	
	private int subReqID;
	
	private int respCode;
	
	private String desc;
	
	public SubscribeResp() {
		super();
	}

	
	public SubscribeResp(int subReqID, int respCode, String desc) {
		this.subReqID = subReqID;
		this.respCode = respCode;
		this.desc = desc;
	}






	public int getSubReqID() {
		return subReqID;
	}




	public void setSubReqID(int subReqID) {
		this.subReqID = subReqID;
	}




	public int getRespCode() {
		return respCode;
	}




	public void setRespCode(int respCode) {
		this.respCode = respCode;
	}




	public String getDesc() {
		return desc;
	}




	public void setDesc(String desc) {
		this.desc = desc;
	}




	/**
	 * @see Object#toString()
	 */

	@Override
	public String toString() {
		return "SubscribeResp [subReqID=" + subReqID + ", respCode=" + respCode
				+ ", desc=" + desc + "]";
	}
	
	
	

	

}
