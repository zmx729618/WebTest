package advance.java.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class HomePageReader {
	
	public static void main(String[] args) {
		Socket socket =null;
		try {
		  //socket = new Socket("www.baidu.com", 80);
			socket = new Socket("localhost", 8888);
			
			OutputStream outputStream = socket.getOutputStream();
			String getRequest = "GET / HTTP/1.0\n\n";   //http协议
			outputStream.write(getRequest.getBytes());
			InputStream inputStream = socket.getInputStream();
			Scanner scanner = new Scanner(inputStream);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				System.out.println(line);				
			}
			

		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			try {
				socket.close();
			} catch (IOException e) {			
				e.printStackTrace();
			}
		}
		
		
	}

}
