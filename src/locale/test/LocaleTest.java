package locale.test;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.core.SimpleAliasRegistry;

public class LocaleTest {
	
	public static void main(String[] args) {
		
		Locale locale =  new Locale("zh", "CN");
		
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		
		double rmb = 123456.78;
		
		System.out.println(numberFormat.format(rmb));
		
		
		Date date = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, locale);
		System.out.println(df.format(date));
		
		
		String pattern1 = "{0}，您好！ 你于{1}在工商银行存入{2}元.";
		String pattern2 = "At {1,time,short} On {1,date,long},{0} paid {2,number,currency}";
		
		Object[] params = {"john",new GregorianCalendar().getTime(),1.0E3};
		
		String msg1 = MessageFormat.format(pattern1, params);
		
		
		MessageFormat mf = new MessageFormat(pattern2,Locale.US);
		
		String msg2 = mf.format(params);
		
		System.out.println(msg1);
		System.out.println(msg2);
		
	}
	

	


}
