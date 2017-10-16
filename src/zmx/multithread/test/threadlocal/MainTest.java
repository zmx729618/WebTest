package zmx.multithread.test.threadlocal;

import java.text.DateFormat;
import java.util.Date;

public class MainTest {
	
	
	public static void main(String[] args) {
		
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Date d = new Date();
				DateFormat dateFormat = DateFormatFactory.getDateFormat(DatePattern.DatePattern);
				
				dateFormat.format(d);
				System.out.println(d);
				
			}
		});
		t.start();
		
	}

}
