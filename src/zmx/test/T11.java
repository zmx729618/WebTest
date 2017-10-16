package zmx.test;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class T11 {
	
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy");
		String year = df.format(new Date());
		String saveDir = "E:/file" +  File.separator + year;
		System.out.println(saveDir);
		Properties props = System.getProperties();  
		Runtime runtime = Runtime.getRuntime(); 
		System.out.println(runtime);
		long freeMemoery = runtime.freeMemory();  
		System.out.println(freeMemoery);
		long totalMemory = runtime.totalMemory(); 
		System.out.println(totalMemory);
		long usedMemory = totalMemory - freeMemoery;  
		System.out.println(usedMemory);
		long maxMemory = runtime.maxMemory();  
		System.out.println(maxMemory);
		long useableMemory = maxMemory - totalMemory + freeMemoery;
		System.out.println(useableMemory);

	}

}
