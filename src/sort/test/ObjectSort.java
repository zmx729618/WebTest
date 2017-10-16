package sort.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class ObjectSort {
	
	static class User {  
		  
	    private String name;    //姓名   
	    private String birthday;//出生日期   
	      
	    public  User(String name, String birthday) {  
	        this.name = name;  
	        this.birthday = birthday;  
	    }  
	  
	    public String getName() {  
	        return name;  
	    }  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	    public String getBirthday() {  
	        return birthday;  
	    }  
	    public void setBirthday(String birthday) {  
	        this.birthday = birthday;  
	    }  
	}
	
	public static void main(String[] args){
		
        List<User> userList = new ArrayList<User>();  
        
        userList.add(new User("王琦", "2014-03-28 10:00:24"));  
        userList.add(new User("刘明", "2014-06-20 09:10:55"));  
        userList.add(new User("张国龙", "2014-06-12 09:05:40"));  
        userList.add(new User("刘青", "2014-05-23 13:37:02"));  
        userList.add(new User("费楠", "2014-04-22 09:41:46"));  
        userList.add(new User("王国栋", "2014-05-19 15:35:31")); 
        
        Collections.sort(userList, new Comparator<User>(){  
            @Override  
            public int compare(User a, User b) {//将List依照出生日期倒序排序   
                return b.getBirthday().compareTo(a.getBirthday());  
            }  
        }); 
        
        for (User user:userList) {  
            System.err.println("姓名：" + user.getName() + "，出生日期：" + user.getBirthday());  
        } 
		
	}

}
