package file.stream.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OutputStreamTest {
	public static void main(String[] args) {
		
		int numberRead = 0;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		byte[] buffer = new byte[128];
		
		String fileName = "D:/Workspaces/projects/testWeb/WebRoot/WEB-INF/classes/file/stream/test/build.xml";
		String copyOfFileName = "copyOfBuild.xml";
		
		try {
			inputStream = new FileInputStream(fileName);
	        File file = new File(copyOfFileName);
	        if(!file.exists()){
	        	file.createNewFile();
	        }
	        outputStream = new FileOutputStream(file);
			while((numberRead = inputStream.read(buffer)) != -1){
				outputStream.write(buffer,0, numberRead );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("go on");
		
		
		
		
		
	}

}
