package zmx.calendar.test;


import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Scanner;  
  
public class CalenderTest{  
 
    private static int getdataCount(int year, int month) {  
        Calendar cal = Calendar.getInstance();  
        cal.set(Calendar.YEAR, year);  
        cal.set(Calendar.MONTH, month - 1);  
        int count = cal.getActualMaximum(Calendar.DATE);  
        return count;  
    } 
    
    
    public static void main(String[] args) throws ParseException {  
        Calendar cal = Calendar.getInstance();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Scanner input = new Scanner(System.in);  
        System.out.println("请输入要显示的年份");  
        int year = input.nextInt();  
        System.out.println("请输入要显示的月份");  
        int month = input.nextInt();  
        int count = getdataCount(year, month);  
        cal.setTime(sdf.parse(year + "-" + month + "-" + 1));  
        int first = cal.get(Calendar.DAY_OF_WEEK);  
        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");  
        for (int i = 1; i < first; i++) {  
            System.out.print("\t");  
        }  
        for (int i = 1; i <= count; i++) {  
            System.out.print(i + "\t");  
            cal.setTime(sdf.parse(year + "-" + month + "-" + i));  
            if (cal.get(Calendar.DAY_OF_WEEK) == 7) {  
                System.out.println();  
            }  
        }  
    } 
}  