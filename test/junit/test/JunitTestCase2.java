package junit.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JunitTestCase2 {
	
	private SimpleDateFormat simpleDateFormat;
	
	private String date;
	 
	private String dateformat;
	
	private String expectedDate;

	
	public JunitTestCase2(String date, String dateformat, String expectedDate) {

		this.date = date;
		this.dateformat = dateformat;
		this.expectedDate = expectedDate;
	}
	
	@Parameters
	public static Collection getparameters(){
		
		String[][] object = {
				
				{"2015-03-27","yyyy-MM-dd","2015-03-27"},
				{"2015-03-27","yyyy年MM月dd日","2015年03月27日"},
				{"2015-03-27","yyyy/MM/dd","2015/03/27"}
				
		};
		
		return Arrays.asList(object);
		
		
	}
	
	@Test
	public void testSimpleDateFormat() throws ParseException{
		
		SimpleDateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
		
		Date d =  df.parse(this.date);
		
		simpleDateFormat = new SimpleDateFormat(this.dateformat);
		
		String result = simpleDateFormat.format(d);
		
		assertEquals(this.expectedDate,result);
		
		
	}
	
	
	 
	 
	 
	

}
