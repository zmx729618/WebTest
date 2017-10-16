package file.code;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
	
	public static void main(String[] args) throws Exception {
		File localFile = new File("src/file/code/Client.java");
		System.out.println(localFile.toURI());
		System.out.println(localFile.toURI().toURL());
		
		System.out.println(GetFileCodeTools.getLocalFileEncode(localFile));
		
		
		
        List<String> stringList = new ArrayList<String>();  
        stringList.add("fd422114-0f9f-4f04-bc79-09698121f999");  
        stringList.add("5de14c97-348c-46b6-8519-f246b5f53d3a");  
        stringList.add("b2056a9e-8fba-4119-ab5a-79d3ec0100e0");  
        stringList.add("20254564-796e-43d5-bcd2-9fe157f2b18c");  
        stringList.add("sa31b130-9064-42d9-be2c-321773b2b2b5"); 
        
        System.out.println(stringList.toString());
        Matcher matcher = Pattern.compile("^\\[| |\\]$").matcher(stringList.toString());
        
        System.out.println(matcher.find());
        System.out.println(matcher.group());
        System.out.println(stringList.toString().replaceAll("^\\[| |\\]$", ""));
	}

}
