package zmx.multithread.test.threadlocal;

public enum DatePattern {
	
	TimePattern("yyyy-MM-dd HH:mm:ss"),
	DatePattern("yyyy-MM-dd");
	
	public String pattern;
	
	private DatePattern(String pattern){
		this.pattern = pattern;
	}
	

}
