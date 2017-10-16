package zmx.crontab.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class T1 {
	
	public static void main(String[] args) {
		
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(3);  
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        System.out.println(" begin to do something at:" + sdf.format(new Date()));  
        schedule.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
		        try {  
		        	   Thread.sleep(5000);  
		        	} catch (InterruptedException ex) {  
		        	   ex.printStackTrace();  
		            }  
		            System.out.println("do something  at:" + sdf.format(new Date())); 

				
			}
		}, 1, 2, TimeUnit.SECONDS); 

		
	}

}
