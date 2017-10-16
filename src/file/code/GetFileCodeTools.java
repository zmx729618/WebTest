package file.code;

import info.monitorenter.cpdetector.io.ASCIIDetector;
import info.monitorenter.cpdetector.io.ByteOrderMarkDetector;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;
import info.monitorenter.cpdetector.io.ParsingDetector;
import info.monitorenter.cpdetector.io.UnicodeDetector;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class GetFileCodeTools {
	
	
	/** 
     * 获取本地文件的编码格式  
     * @param file 要判断编码格式 的文件
     * @author zhangwenchao
     */  
    public static String getLocalFileEncode(File localFile) {  
  
        /* 
         * cpDetector是探测器，它把探测任务交给具体的探测实现类的实例完成。 
         * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、ByteOrderMarkDetector、JChardetFacade、ASCIIDetector、UnicodeDetector。 
         * cpDetector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的字符集编码。cpDetector是基于统计学原理的，不保证完全正确。 
         */  
        CodepageDetectorProxy codepageDetector = CodepageDetectorProxy.getInstance();  
        codepageDetector.add(new ParsingDetector(false));//ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于指示是否显示探测过程的详细信息，为false不显示。   
        codepageDetector.add(JChardetFacade.getInstance());//JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。   
        codepageDetector.add(new ByteOrderMarkDetector());    
        codepageDetector.add(ASCIIDetector.getInstance());//ASCIIDetector用于ASCII编码测定   
        codepageDetector.add(UnicodeDetector.getInstance());//UnicodeDetector用于Unicode家族编码的测定   
        Charset charset = null;  
        try {  
            charset = codepageDetector.detectCodepage(localFile.toURI().toURL());  
            if (charset != null){  
                return charset.name();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
      
    /** 
     * 获得远程URL文件的编码格式 
     *  
     * @param url 远程文件的URL路径 
     *  
     * @author 高焕杰 
     */  
    public static String getURLFileEncode(URL url) {  
  
        /* 
         * cpDetector是探测器，它把探测任务交给具体的探测实现类的实例完成。 
         * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、ByteOrderMarkDetector、JChardetFacade、ASCIIDetector、UnicodeDetector。 
         * cpDetector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的字符集编码。cpDetector是基于统计学原理的，不保证完全正确。 
         */  
        CodepageDetectorProxy codepageDetector = CodepageDetectorProxy.getInstance();  
        codepageDetector.add(new ParsingDetector(false));//ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于指示是否显示探测过程的详细信息，为false不显示。   
        codepageDetector.add(JChardetFacade.getInstance());//JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。   
        codepageDetector.add(ASCIIDetector.getInstance());//ASCIIDetector用于ASCII编码测定   
        codepageDetector.add(UnicodeDetector.getInstance());//UnicodeDetector用于Unicode家族编码的测定   
        Charset charset = null;  
        try {  
            charset = codepageDetector.detectCodepage(url);  
            if (charset != null){  
                return charset.name();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
      
    /** 
     * 获得文件流的编码格式 
     *  
     * @param inputStream 文件流 
     *  
     * @author 高焕杰 
     */  
    public static String getInputStreamEncode(InputStream inputStream) {  
  
        /* 
         * cpDetector是探测器，它把探测任务交给具体的探测实现类的实例完成。 
         * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、ByteOrderMarkDetector、JChardetFacade、ASCIIDetector、UnicodeDetector。 
         * cpDetector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的字符集编码。cpDetector是基于统计学原理的，不保证完全正确。 
         */  
        CodepageDetectorProxy codepageDetector = CodepageDetectorProxy.getInstance();  
        codepageDetector.add(new ParsingDetector(false));//ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于指示是否显示探测过程的详细信息，为false不显示。   
        codepageDetector.add(JChardetFacade.getInstance());//JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。   
        codepageDetector.add(ASCIIDetector.getInstance());//ASCIIDetector用于ASCII编码测定   
        codepageDetector.add(UnicodeDetector.getInstance());//UnicodeDetector用于Unicode家族编码的测定   
        Charset charset = null;  
        try {  
            charset = codepageDetector.detectCodepage(inputStream, 0);  
            if (charset != null){  
                return charset.name();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
      
    /** 
     * 获得字符串的编码格式 
     *  
     * @param stringValue 要判断的文件编码格式字符串 
     *  
     * @author 高焕杰 
     */  
    public static String getStringEncode(String stringValue) {  
  
        /* 
         * cpDetector是探测器，它把探测任务交给具体的探测实现类的实例完成。 
         * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、ByteOrderMarkDetector、JChardetFacade、ASCIIDetector、UnicodeDetector。 
         * cpDetector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的字符集编码。cpDetector是基于统计学原理的，不保证完全正确。 
         */  
        CodepageDetectorProxy codepageDetector = CodepageDetectorProxy.getInstance();  
        codepageDetector.add(new ParsingDetector(false));//ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于指示是否显示探测过程的详细信息，为false不显示。   
        codepageDetector.add(JChardetFacade.getInstance());//JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。   
        codepageDetector.add(ASCIIDetector.getInstance());//ASCIIDetector用于ASCII编码测定   
        codepageDetector.add(UnicodeDetector.getInstance());//UnicodeDetector用于Unicode家族编码的测定   
        Charset charset = null;  
        try {  
            InputStream inputStream = new ByteArrayInputStream(stringValue.getBytes());  
            charset = codepageDetector.detectCodepage(inputStream, 3);  
            if (charset != null){  
                return charset.name();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    
    
    /**
     * 将GBK编码格式的文件转换为UTF-8编码格式的文件 
     * @param gbkDirPath
     * @param utf8DirPath
     * @throws IOException 
     */
    public void GBKToUTF8(String gbkDirPath,String utf8DirPath) throws IOException{
        gbkDirPath = "D:\\GBK\\src";//GBK编码格式源码文件路径   
        utf8DirPath = "D:\\UTF8\\src";//转为UTF-8编码格式源码文件保存路径   
  
        @SuppressWarnings("unchecked")  
        Collection<File> gbkFileList =  FileUtils.listFiles(new File(gbkDirPath), new String[]{"java"}, true);//获取所有java文件   
        for (File gbkFile : gbkFileList) {  
            String utf8FilePath = utf8DirPath + gbkFile.getAbsolutePath().substring(gbkDirPath.length());//UTF-8编码格式文件保存路径   
            FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(gbkFile, "GBK"));//使用GBK编码格式读取文件，然后用UTF-8编码格式写入数据   
        }  
    	
    }


}
