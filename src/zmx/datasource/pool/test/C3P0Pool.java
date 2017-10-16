package zmx.datasource.pool.test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;



public class C3P0Pool {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			DataSource unpooled = DataSources.unpooledDataSource("jdbc:mysql://localhost:3306/bcp", "root", "0729");
			DataSource pooled = DataSources.pooledDataSource(unpooled);  //返回一个数据库连接池
			conn = pooled.getConnection();    //第一次取得数据库连接
			System.out.println(conn.getClass().getName());
			Object o1 = getInnter(conn);  
			System.out.println("Inner con Class Type is:"+ o1.getClass().getName());
			prst = conn.prepareStatement("select * from t_p_user");
			rs = prst.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
			rs.close();
			prst.close();
			conn.close();
			
			
			
			Thread.sleep(1000);
			conn = pooled.getConnection();    //第二次取得数据库连接
			Object o2 = getInnter(conn);  
			if(o1==o2){
				System.out.println("o1 and o2 is same object");
			}
			prst = conn.prepareStatement("select * from t_p_user");
			rs = prst.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
			rs.close();
			prst.close();
			conn.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static Object getInnter(Connection conn) {
		Object obj = null;
		Field f = null;
		try{
			f = conn.getClass().getDeclaredField("inner"); //反射获取inner属性
			f.setAccessible(true); //修改属性访问权限
			obj = f.get(conn);  //返回conn对象的inner属性的值
			f.setAccessible(false);
			
			
			
					
		}catch (Exception e) {
			
		}
		return obj;
	}

}
