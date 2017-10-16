package date.utils.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	
	/** 
     * 将毫秒转换为年月日时分秒 
     *  
     * @author zhangwenchao 
     */  
    public static  String getYearMonthDayHourMinuteSecond(long timeMillis) { 
    	
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));   //获取东8区时区
        calendar.setTimeInMillis(timeMillis);  
        int year=calendar.get(Calendar.YEAR);  
        int month=calendar.get(Calendar.MONTH) + 1;    //月份从0开始的
        String mToMonth=null;  
        if (String.valueOf(month).length()==1) {  
            mToMonth="0"+month;  
        } else {  
            mToMonth=String.valueOf(month);  
        }  
        int day=calendar.get(Calendar.DAY_OF_MONTH);  
        String dToDay=null;  
        if (String.valueOf(day).length()==1) {  
            dToDay="0"+day;  
        } else {  
            dToDay=String.valueOf(day);  
        }  
          
        int hour=calendar.get(Calendar.HOUR_OF_DAY);  
        String hToHour=null;  
        if (String.valueOf(hour).length()==1) {  
            hToHour="0"+hour;  
        } else {  
            hToHour=String.valueOf(hour);  
        }  
          
        int minute=calendar.get(Calendar.MINUTE);  
        String mToMinute=null;  
        if (String.valueOf(minute).length()==1) {  
            mToMinute="0"+minute;  
        } else {  
            mToMinute=String.valueOf(minute);  
        }  
          
        int second=calendar.get(Calendar.SECOND);  
        String sToSecond=null;  
        if (String.valueOf(second).length()==1) {  
            sToSecond="0"+second;  
        } else {  
            sToSecond=String.valueOf(second);  
        }  
        return  year+ "-" +mToMonth+ "-" +dToDay+ " "+hToHour+ ":" +mToMinute+ ":" +sToSecond;        
    }  
    
	/** 
     * 将毫秒转换为年月日时分秒 
     *  
     * @author zhangwenchao 
     */
    public static String getYearMonthDayHourMinuteSecond2(long timeMillis) {
    	Date date = new Date(timeMillis);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return sdf.format(date);
    }
    
    
    
    /** 
     * 获取距离系统时间+N天 的日期时间信息 
     *  
     * @author zhangwenchao
     */  
    public static String getDateAfterNdays(int days){  
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));  
        return  getYearMonthDayHourMinuteSecond(System.currentTimeMillis()+1000L * 60 * 60 * 24 * days);
    } 

   
    
    /** 
     * 获取给定时间与当前系统时间的差值（以毫秒为单位） 
     *  
     * @author GaoHuanjie 
     */  
    public static long getTimeDifferenceBetweenSystemTimeAndParamTime(String paramTime) {  
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String systemTime = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(new Date().getTime());// 获取系统时间   
        long difference = 0;  
        try {  
            Date systemDate = dateFormat.parse(systemTime);  
            Date paramDate = dateFormat.parse(paramTime);  
            difference = systemDate.getTime() - paramDate.getTime();  
            System.out.println("系统时间：" + systemTime + "，给定时间：" + paramTime  + "，给定时间与当前系统时间的差值（以毫秒为单位）：" + difference + "毫秒");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return difference;  
    } 
    
    
    
    public static void main(String[] args) {
    	
    	System.out.println(DateUtil.getYearMonthDayHourMinuteSecond(System.currentTimeMillis()));
    	System.out.println(DateUtil.getYearMonthDayHourMinuteSecond2(System.currentTimeMillis()));
    	System.out.println(DateUtil.getDateAfterNdays(28));
    	
    	System.out.println(DateUtil.getTimeDifferenceBetweenSystemTimeAndParamTime("2015-06-04 14:48:47"));
		
	}

}
