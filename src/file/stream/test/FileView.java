package file.stream.test;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileView {
	
	public static void main(String[] args) {
		int numberread = 0;
		FileReader fileReader = null;
		PrintWriter printWriter =  null;
		
		char[] buffer = new char[128];
		String fileName = "D:/Workspaces/projects/testWeb/WebRoot/WEB-INF/classes/file/stream/test/build.xml";
		try {
			fileReader = new FileReader(fileName);
			printWriter = new PrintWriter(System.out);
			while((numberread = fileReader.read(buffer))!=-1){
				printWriter.write(buffer, 0, numberread);
			}
		} catch (Exception e) {		
			e.printStackTrace();
		}finally{
			try {
				fileReader.close();
				printWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
				 
		
	}

}
