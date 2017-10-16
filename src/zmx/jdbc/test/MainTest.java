package zmx.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MainTest {
	
	public static void main(String[] args) {
		
	    try{    
	        //加载MySql的驱动类    
	        Class.forName("com.mysql.jdbc.Driver");   	        	        
	        String url = "jdbc:mysql://localhost:3306/test" ;     
	        String username = "root" ;    
	        String password = "0729" ;    
	        try{    
	         Connection conn =  DriverManager.getConnection(url, username, password) ;    
	         
	         ResultSet rs;
			try {
				  conn.setAutoCommit(false);
				 String sql ="select * from  t_user ";
				 PreparedStatement pstmt = conn.prepareStatement(sql) ; 
				 
				 rs = pstmt.executeQuery();
				  while(rs.next()){    
			             String name = rs.getString("name") ;    
			             int age = rs.getInt("age") ; // 此方法比较高效    
			       
			             System.out.println("name: "+name+"   age: "+age);
			         } 
				 conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}finally{
				conn.close();
			}
	       


	        }catch(SQLException se){    
	       System.out.println("数据库连接失败！");    
	       se.printStackTrace() ;    
	        }  

	        }catch(ClassNotFoundException e){    
	        System.out.println("找不到驱动程序类 ，加载驱动失败！");    
	        e.printStackTrace() ;    
	        }  

		
	}

}
