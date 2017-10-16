package zmx.common.net.test;



import java.io.File;    
import java.io.FileInputStream;    
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;    
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;    
    
/**
 * @author 
 * package com.genomics.ib.item.control
 * @title ItemFtp
 * @Description :  FTP 上传下载工具类
 * @time 2013-11-27 
 */
public class ItemFtp {      
       
    private  FTPClient ftp;      
    /**  
     *   
     * @param path 上传到ftp服务器哪个路径下     
     * @param addr 地址  
     * @param port 端口号  
     * @param username 用户名  
     * @param password 密码  
     * @return  
     * @throws Exception  
     */    
    private  boolean connect(String path, String addr, int port, String username, String password) throws Exception {      
        boolean result = false;      
        ftp = new FTPClient();      
        int reply;      
        ftp.connect(addr,port);      
        ftp.login(username,password);      
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);      
        reply = ftp.getReplyCode();      
        if (!FTPReply.isPositiveCompletion(reply)) {      
            ftp.disconnect();      
            return result;      
        }      
        ftp.changeWorkingDirectory(path);      
        result = true;      
        return result;      
    }      
    
    
    
    /**
     * @author 
     * @class  ItemFtp
     * @title  upload
     * @Description : 
     * @time 2013 2013-11-27
     * @return void
     * @exception :(Error note)
     * @param file 上传的文件或文件夹
     * @param path 上传的文件的路径 
     * @throws Exception
     */
    public void upload(File file , String path) throws Exception{     	
    	
        if(file.isDirectory()){  
        	System.out.println( " file.isDirectory() : " + file.isDirectory()  );
            ftp.makeDirectory(file.getName());                
            ftp.changeWorkingDirectory(file.getName());      
            String[] files = file.list();             
            for (int i = 0; i < files.length; i++) {      
                File file1 = new File(file.getPath()+"\\"+files[i] );      
                if(file1.isDirectory()){      
                    upload(file1 , path );      
                    ftp.changeToParentDirectory();      
                }else{                    
                    File file2 = new File(file.getPath()+"\\"+files[i]);      
                    FileInputStream input = new FileInputStream(file2);      
                    ftp.storeFile(file2.getName(), input);      
                    input.close();                            
                }                 
            }      
        }else{                              
            System.out.println( " file.getPath() : " + file.getPath()  + " | file.getName() : " + file.getName() );           
            InputStream input = new FileInputStream(file);               
            ftp.changeWorkingDirectory(path);   
            ftp.storeFile(file.getName(), input);                  
            input.close();  //关闭输入流
            ftp.logout();  //退出连接
        }      
    }    
    
    
       
    /**
     * @author 
     * @class  ItemFtp
     * @title  download
     * @Description : FPT 下载文件方法
     * @time 2013 2013-11-27
     * @return void
     * @exception :(Error note)
     * @param reomvepath 下载的文件的路径 
     * @param fileName  下载的文件名 
     * @param localPath 下载的文件本地路径
     * @throws Exception
     */
	public void download(String movepath, String fileName, String localPath) throws Exception{               
            ftp.changeWorkingDirectory(movepath);              
            // 列出该目录下所有文件
            FTPFile[] fs = ftp.listFiles();
            // 遍历所有文件，找到指定的文件
            for (FTPFile ff : fs) {
	             if (ff.getName().equals(fileName)) {
	              // 根据绝对路径初始化文件
	              File localFile = new File(localPath + "/" + ff.getName());
	              // 输出流
	              OutputStream is = new FileOutputStream(localFile);
	              // 下载文件
	              ftp.retrieveFile(ff.getName(), is);
	              System.out.println("下载成功!");
	              is.close();  
	             }
            }
            
            ftp.logout();  //退出连接
            
    } 
    
   public static void main(String[] args) throws Exception{    
	     
	   ItemFtp t = new ItemFtp();    
      
	   t.connect("D:\\", "127.0.0.1", 21, "jiang", "jiang");    
	  
	  //上传
      File file = new File("d:\\test.txt");  
      t.upload(file , "E:\\ftptest\\mulu");  
      
      //下载
      t.download("E:\\ftptest\\mulu", "test.txt", "D:\\db");
	  
	  
   }    
} 

