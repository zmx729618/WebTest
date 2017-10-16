package zmx.multithread.test.threadlocal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class DateFormatFactory {
	
	private static final Map<DatePattern, ThreadLocal<DateFormat>> pattern2ThreadLocal;
	static {
		  DatePattern[] patterns = DatePattern.values();
		  int len = patterns.length;	
		  pattern2ThreadLocal = new HashMap<DatePattern, ThreadLocal<DateFormat>>(len);
		  for (int i = 0; i < len; i++) {
		    DatePattern datePattern = patterns[i];
		    final String pattern = datePattern.pattern;
		    pattern2ThreadLocal.put(datePattern, new ThreadLocal<DateFormat>() {
		      @Override
		      protected DateFormat initialValue() {
		        return new SimpleDateFormat(pattern);
		      }
		    });
		  }
		}

		//获取DateFormat
		public static DateFormat getDateFormat(DatePattern pattern) {
		  ThreadLocal<DateFormat> threadDateFormat = pattern2ThreadLocal.get(pattern);
		  
		  //不需要判断threadDateFormat是否为空
		  return threadDateFormat.get(); 
		}


}
