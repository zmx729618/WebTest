package file.stream.test;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirList{
	
	public static void main(String[] args) {
		
		URI uri = URI.create("file:///D:/Workspaces/projects/testWeb/WebRoot/WEB-INF/classes/file/stream/test/");
		Path path = Paths.get(uri);
		DirectoryStream<Path> directory = null;
		try{
			
			directory = Files.newDirectoryStream(path,"*.{class,xml}");
			for(Path p : directory){
				System.out.println(p.getFileName());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(directory !=null){
				
				try {
					directory.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

}
