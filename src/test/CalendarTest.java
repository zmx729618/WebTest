package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
	
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy-MM-dd");
		
		Calendar c = Calendar.getInstance();  
        c.set(2014,0,01);  
          
		
		System.out.println("当前时间:"+dateFormat.format(new Date(c.getTimeInMillis())));
		
		
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day-1); 
        
        System.out.println("当前时间:"+dateFormat.format(new Date(c.getTimeInMillis())));
		
        
        day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day+2);
        System.out.println("当前时间:"+dateFormat.format(new Date(c.getTimeInMillis())));
        
        if(c instanceof GregorianCalendar){
        	System.out.println("it is an instance of GregorianCalendar");
        }
        //  c.set(Calendar.MILLISECOND, 0);
        System.out.println(c.get(Calendar.MILLISECOND));
        
        System.out.println("当前时间:"+dateFormat.format(new Date(c.getTimeInMillis())));
        
        
	}

}
