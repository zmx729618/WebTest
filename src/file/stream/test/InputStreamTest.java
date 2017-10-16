package file.stream.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {
	
	public static void main(String[] args) {
		
		int count = 0;
		String FileName = "D:/Workspaces/projects/testWeb/WebRoot/WEB-INF/classes/file/stream/test/build.xml";
		InputStream inputStream = null;
		try {
		    //inputStream = new FileInputStream(new  File(FileName));
		    inputStream = new FileInputStream(FileName);
			byte[] b = new byte[128];
			while(inputStream.read(b) !=-1){
				count += b.length;
				String str = new String(b);
				System.out.println(str);
			}
			System.out.println(count);
		} catch (Exception e) {	
			e.printStackTrace();
			System.exit(0);
		}finally{
			try {
				inputStream.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}	
		}
		
		
		
		
				
		
	}

}
