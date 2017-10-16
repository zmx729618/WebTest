package zwc.framwork;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.ModelMap;

public class Person {
	
	private String username;
	
	private String passwd;
	
	private String realName;
	
	private Double price;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
/*	*//**
	 * 控制器初始化时调用
	 * SpringMVC 使用WebDataBinder处理<请求消息,方法入参>的绑定工作
	 * @param binder
	 *//*
	public void initBinder(WebDataBinder binder){
		
		binder.registerCustomEditor(Person.class, new PersonEditor()); 
		//binder.setValidator(this.validator);  //
	}
		
	*//**
	 * 类型转换测试
	 * @param person
	 * @param modelMap
	 * @return
	 *//*
	@RequestMapping("/test/conversion")
	public String conversionTest(@RequestParam("person")Person person,ModelMap modelMap){
		
		System.out.println(person.getUsername()+" "+person.getPasswd()+" "+person.getRealName()+" "+ person.getPrice());
		modelMap.put("person", person);
		return "/test/test";
	}*/

}
