package file.stream.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Trade {
	
	private int scriptCode;
	
	private byte[] time;
	
	private double bid,offer,high,low;
	
	private long quantity;
	
	public Trade(int i) {
     
		scriptCode = 1+i;
		time = now("HH:mm:ss").getBytes();
		bid = Math.random()*1000;
		offer = Math.random()*1000;
		high = Math.random()*1000;
		low = Math.random()*1000;
		quantity = (long)(Math.random()*10000);
		
	}
	
	
	
	
	
	public int getScriptCode() {
		return scriptCode;
	}





	public void setScriptCode(int scriptCode) {
		this.scriptCode = scriptCode;
	}





	public byte[] getTime() {
		return time;
	}





	public void setTime(byte[] time) {
		this.time = time;
	}





	public double getBid() {
		return bid;
	}





	public void setBid(double bid) {
		this.bid = bid;
	}





	public double getOffer() {
		return offer;
	}





	public void setOffer(double offer) {
		this.offer = offer;
	}





	public double getHigh() {
		return high;
	}





	public void setHigh(double high) {
		this.high = high;
	}





	public double getLow() {
		return low;
	}





	public void setLow(double low) {
		this.low = low;
	}





	public long getQuantity() {
		return quantity;
	}





	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}





	private String now(String dateFormat){
		
		Calendar calendar = Calendar.getInstance();
		DateFormat format = new SimpleDateFormat(dateFormat);		
		return format.format(calendar.getTime());
	}
	 
	

}
