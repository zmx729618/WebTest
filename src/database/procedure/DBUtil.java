package database.procedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	/** 
     * 功能:获取与MySql的连接 
     *  
     * @author zhangwenchao
     */  
    public static Connection getMySqlConnection() {  
        Connection connection = null;  
        String url = "jdbc:mysql://localhost:3306/ejbtest";  
        String user = "root";  
        String pwd = "0729";  
        String driverName = "com.mysql.jdbc.Driver";  
        try {  
            Class.forName(driverName);  
            connection = DriverManager.getConnection(url, user, pwd);  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }   
        return connection;  
    }  
  
    /** 
     * 关闭释放所有的资源 
     *  
     * @author GaoHuanjie 
     */  
    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {  
        if (rs != null){  
            try {  
                rs.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
        if (ps != null){  
            try {  
                ps.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
        if (con != null){  
            try {  
                con.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
    }  


}
