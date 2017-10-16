package zmx.fastjson.test;
import java.util.Date;
import com.fasterxml.jackson.annotation.*;

public class User {
	private String name;
	
	//不JSON序列化年龄属性
	@JsonIgnore 
	private Integer age;
	
	//格式化日期属性
	@JsonFormat(pattern = "yyyy年MM月dd日",timezone="GMT+08")
	private Date birthday;
	
	//序列化email属性为mail
	@JsonProperty("mail")
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}



