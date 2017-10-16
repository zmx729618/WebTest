package file.attribute.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.junit.Test;

public class DemoTest {
	
	@Test
    public void testReadFileAttribute1(){  
        Path filePath = Paths.get("D:\\baiduyundownload\\4高级班全套视频\\高级班全套视频\\高级班-1-ZooKeeper的集群安装与操作\\g1-1.avi");  
        try{  
            BasicFileAttributes ra = Files.readAttributes(filePath, BasicFileAttributes.class);  
            System.out.println("CREATION TIME:" + ra.creationTime());  
            System.out.println("LAST ACCESS TIME:" + ra.lastAccessTime());  
            System.out.println("FILE SIZE:" + ra.size());  
            System.out.println("LAST MODIFIED:" + ra.lastModifiedTime());  
            System.out.println("IS SYSBOLIC LINK:" + ra.isSymbolicLink());  
            System.out.println("IS FOLDER:" + ra.isDirectory());  
            System.out.println("IS FILE:" + ra.isRegularFile());  
              
        }catch(IOException e){  
            Logger.getLogger(DemoTest.class.getName()).log(Level.SEVERE, null, e);  
        }  
    }
	
	
	
	
	@Test
	public void testReadFileAttribute2(){     
	        Path fp = Paths.get("D:\\baiduyundownload\\4高级班全套视频\\高级班全套视频\\高级班-1-ZooKeeper的集群安装与操作\\g1-1.avi");   
	        try{  
	            Files.getAttribute(fp, "basic:size");  
	            System.out.println("CREATION TIME:" + Files.getAttribute(fp,"basic:creationTime").toString());  
	            System.out.println("LAST ACCESS TIME:" + Files.getAttribute(fp, "basic:lastAccessTime").toString());  
	            System.out.println("FILE SIZE:" + Files.getAttribute(fp, "basic:size").toString());  
	            System.out.println("LAST MODIFIED:" + Files.getAttribute(fp, "basic:lastModifiedTime").toString());  
	            System.out.println("IS SYSBOLIC LINK:" + Files.getAttribute(fp, "basic:isSymbolicLink").toString());  
	            System.out.println("IS FOLDER:" + Files.getAttribute(fp, "basic:isDirectory").toString());  
	            System.out.println("IS FILE:" + Files.getAttribute(fp, "basic:isRegularFile").toString());  
	        }catch(IOException e){  
	            Logger.getLogger(DemoTest.class.getName()).log(Level.SEVERE, null, e);  
	        }  
	          	      
	}
	
	
	@Test
	public void testUpdateFileAttribute1(){     
	        Path fp = Paths.get("D:\\baiduyundownload\\4高级班全套视频\\高级班全套视频\\高级班-1-ZooKeeper的集群安装与操作\\g1-1.avi");   
	        try{  
	            BasicFileAttributes ra = Files.readAttributes(fp, BasicFileAttributes.class);  
	            long currentTimeMillis = System.currentTimeMillis();  
	            FileTime fileTime = FileTime.fromMillis(currentTimeMillis);  
	            Files.setLastModifiedTime(fp, fileTime);  
	            FileTime time = (FileTime)Files.getAttribute(fp, "basic:lastModifiedTime");  
	            System.out.println("NEW LAST-MODIFIED-TIME:" + time.toString());  
	            System.out.println("OLD LAST-MODIFIED-TIME:" + ra.lastModifiedTime());  
	        }catch(IOException e){  
	            Logger.getLogger(DemoTest.class.getName()).log(Level.SEVERE, null, e);  
	        }  
	          	      
	}
	
	
	@Test
	public void testUpdateFileAttribute2(){     
	        Path fp = Paths.get("D:\\baiduyundownload\\4高级班全套视频\\高级班全套视频\\高级班-1-ZooKeeper的集群安装与操作\\g1-1.avi");   
	        try{  
	            BasicFileAttributes ra = Files.readAttributes(fp, BasicFileAttributes.class);  
	            long currentTimeMillis = System.currentTimeMillis();  
	            FileTime fileTime = FileTime.fromMillis(currentTimeMillis);  
	            Files.setAttribute(fp, "basic:creationTime", fileTime);  
	            FileTime creationTime = (FileTime)Files.getAttribute(fp, "basic:creationTime");  
	            System.out.println("NEW CREATION TIME:" + creationTime.toString());  
	            System.out.println("OLD CREATION TIME:" + ra.creationTime());  
	        }catch(IOException e){  
	            Logger.getLogger(DemoTest.class.getName()).log(Level.SEVERE, null, e);  
	        }  
	          	      
	}
	
	
	
	
	
	
	
	
	

}
