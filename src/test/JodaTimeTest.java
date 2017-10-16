package test;

import org.joda.time.DateTime;

public class JodaTimeTest {
	
	public static void main(String[] args) {
		DateTime dt = new DateTime();
		
		DateTime day = dt.plusYears(2);
		
		System.out.println(day.toString("yyyy-MM-dd"));
		
	}

}
