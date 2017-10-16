package xml.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamParseTest {
	
	private static XStream xStream;
	
	static{
		// 创建XStream实例并指定一个XML解析器
		xStream = new XStream(new DomDriver());
		
		//设置类别名
		xStream.alias("users",List.class );
		xStream.alias("user", User.class);
		xStream.alias("log", Log.class);
		
		//设置属性类属性别名
		xStream.aliasField("age", User.class, "age");
		
		//把User的id 视为 xml的属性
		xStream.aliasAttribute(User.class, "id", "id");
		xStream.useAttributeFor(User.class, "id");
		
		
		xStream.autodetectAnnotations(true);
	//	xStream.registerLocalConverter(Log.class, "date", new  MyXStreamDateConverter());
		
	}
	
	
	/**
	 * java对象转化为XML
	 * @throws Exception
	 */
	public static void objectToXML() throws Exception{
		
		User u = new User();
		
		u.setId(3);
		u.setName("萨木普");
		u.setSex("女");
		
		Log log1 = new Log();
		log1.setId(2);
		log1.setIp("127.0.0.1");
		
		Log log2 = new Log();
		log2.setId(2);
		log2.setIp("127.0.0.1");
		
		List<Log> logs =  new  ArrayList<Log>();
		
		logs.add(log1);
		logs.add(log2);
		
		FileOutputStream  outputStream = new FileOutputStream(new File("D:\\Workspaces\\projects\\testWeb\\src\\xml\\test\\userOutput.xml"));
		
		
		xStream.toXML(u, outputStream);

	}
	
	
	/**
	 * xml转换为java
	 * @throws Exception 
	 * 
	 */
	public static void XMLToObject() throws Exception{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		FileInputStream  inputStream = new FileInputStream(new File("D:\\Workspaces\\projects\\testWeb\\src\\xml\\test\\user.xml"));
		
		System.out.println(inputStream);
		
	    List<User> users = (List<User>) xStream.fromXML(inputStream);
		
		for(User u : users){
			System.out.println( u.getName());
			for(Log l:u.getLogs()){
				System.out.println(l.getIp());
				System.out.println(dateFormat.format(l.getDate()));
			}
		}
		
		
	}
	 
	
	public static void main(String[] args) throws FileNotFoundException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		FileInputStream  inputStream = new FileInputStream(new File("D:\\Workspaces\\projects\\testWeb\\src\\xml\\test\\user.xml"));
		
		System.out.println(inputStream);
		
		List<User> users = (List<User>) xStream.fromXML(inputStream);
			
        for(User u : users){
			
			System.out.println("id:"+u.getId()+"  name:" + u.getName());
			
			for(Log l:u.getLogs()){
				
				System.out.println(l.getIp());
				System.out.println(dateFormat.format(l.getDate()));
			}
		}
		
		System.out.println("读取成功！");
		
		
		
		
	/*	
		User u = new User();
		
		u.setId(3);
		u.setName("萨木普");
		u.setSex("女");
		
		Log log1 = new Log();
		log1.setId(2);
		log1.setIp("127.0.0.1");
		
		Log log2 = new Log();
		log2.setId(2);
		log2.setIp("127.0.0.1");
		
		List<Log> logs =  new  ArrayList<Log>();
		
		logs.add(log1);
		logs.add(log2);
		
		u.setLogs(logs);
		FileOutputStream  outputStream = new FileOutputStream(new File("D:\\Workspaces\\projects\\testWeb\\src\\xml\\test\\userOutput.xml"));
		
		
		xStream.toXML(u, outputStream);
		
		System.out.println("保存成功！");*/

	}

}
