package zmx.webservice.test;

public class FristService {
	public String sayHello(String name){
	System.out.println(name+"在调用sayHello...");
	if(name==null || "".equals(name)){
	return "请输入name.";
	}
	return "hello,"+name;
	}
}
