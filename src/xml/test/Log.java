package xml.test;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamConverter;




public class Log {
	
	private int id;
	
	private String ip;
	
	@XStreamConverter(MyXStreamDateConverter.class)
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	

}
