package database.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallProcedure {
	
	
	/** 
	 * 没有任何输入和输出参数的存储过程 
	 *  
	 * @author zhangwenchao
	 * 
	 * CREATE PROCEDURE noParam() 
	   BEGIN 
		SELECT AVG(price) AS priceAvg FROM fruit; 
	   END$$ 
	   DELIMITER ;
	 */
	public void callProcedureNoParam() throws SQLException{
		
		Connection connection = DBUtil.getMySqlConnection();  
        String proStr = "{call noParam}";  
        CallableStatement callableStatement = connection.prepareCall(proStr);  
        callableStatement.execute();  
        ResultSet resultSet = callableStatement.getResultSet();  
        while (resultSet.next()) {  
            System.out.println("产品的平均价格是：" + resultSet.getDouble("priceAvg") + "元");  
        }  
        DBUtil.close(connection, callableStatement, resultSet);  
		
	}
	
	
    /** 
	 * 
	 * 只有输入参数的存储过程 
	 *  CREATE PROCEDURE inTwoParam(IN fruitName VARCHAR(12),IN fruitPrice DECIMAL(9,2))     //说明：fruitPrice参数的数据类型与price列的数据类型不一致（price的类型为（8,2）），对这一现象应该有所感悟。 
		BEGIN 
		SELECT * FROM fruit WHERE NAME LIKE CONCAT('%',fruitName,'%') AND price < fruitPrice;//注意：CONCAT('%',fruitName,'%')不能为'%'+fruitName+'%' 
		END
	 *  
	 * @author zhangwenchao
     * @throws SQLException 
	 */ 
	public void callProcedureInputParam(String fruitName, Double fruitPrice) throws SQLException{
		
        Connection connection = DBUtil.getMySqlConnection();  
        String procStr = "{call inTwoParam(?,?)}";  
        CallableStatement callableStatement = connection.prepareCall(procStr);  
        callableStatement.setString(1, fruitName);  
        callableStatement.setDouble(2, fruitPrice);//对DECIMAL类型的属性设值要使用setDouble方法。   
        callableStatement.execute();  
        ResultSet resultSet = callableStatement.getResultSet();  
        System.out.println("名称包含‘莲’字且价格小于88.88元的水果有：");  
        while (resultSet.next()) {  
            System.err.println("名称：" + resultSet.getString("name") +"、价格：" + resultSet.getDouble("price") + "元"+"、产地：" + resultSet.getString("address"));  
        }  
        DBUtil.close(connection, callableStatement, resultSet);
		
	}
	
	
	/**
	 * 只有输出参数的存储过程
	 *  CREATE PROCEDURE outTwoParam(OUT fruitName VARCHAR(12),OUT fruitPrice DECIMAL(5,3) ) 
		BEGIN 
		SELECT name INTO fruitName FROM fruit WHERE name='莲雾'; 
		SELECT price INTO fruitPrice FROM fruit WHERE NAME='莲雾'; 
		END 
		//注意：上面两条查询语句不能合成一个SQL语句 :
		SELECT NAME INTO fruitName, price INTO fruitPrice FROM fruit WHERE NAME='莲雾'; 
		对比  SELECT NAME,price INTO fruitName,  fruitPrice FROM fruit WHERE NAME='莲雾';
	 * @author zhangwenchao
	 * @throws SQLException 
	 */
	public void callProcedureOutputParam(String fruitName, Double fruitPrice) throws SQLException{
		
        Connection connection = DBUtil.getMySqlConnection();  
        String proStr = "{call outTwoParam(?,?)}";  
        CallableStatement callableStatement = connection.prepareCall(proStr);  
        callableStatement.registerOutParameter(1, Types.VARCHAR);  
        callableStatement.registerOutParameter(2, Types.DECIMAL);  
        callableStatement.execute();  
        fruitName = callableStatement.getString(1);  
        fruitPrice = callableStatement.getDouble(2);// 获取DECIMAL类型的属性要使用getDouble方法。   
        System.out.println("水果名称：" + fruitName +"、水果价格：" + fruitPrice + "元");  
        DBUtil.close(connection, callableStatement, null); 
		
	}
	
	/**
	 *  含有输入参数和输出参数的存储过程 
	 *  CREATE PROCEDURE inOneParamAndOutOneParam(IN fruitName VARCHAR(12),OUT fruitPrice DECIMAL(7,3)) 
		BEGIN 
		SELECT price FROM fruit WHERE NAME=fruitName INTO fruitPrice; 
		END
	 * @throws SQLException 
	 */
	public void callInAndOutputParam(String fruitName, Double fruitPrice) throws SQLException{
        Connection connection=DBUtil.getMySqlConnection();  
        CallableStatement callableStatement=null;  
        String procStr="{call inOneParamAndOutOneParam(?,?)}";  
        callableStatement=connection.prepareCall(procStr);    
        callableStatement.setString(1, fruitName);  
        callableStatement.registerOutParameter(2, Types.DECIMAL);  
        callableStatement.execute();  
        fruitPrice=callableStatement.getDouble(2);//获取DECIMAL类型的属性要使用getDouble方法。   
        System.out.println(fruitName+"的价格为："+fruitPrice+"元");  
        DBUtil.close(connection, callableStatement, null);
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		CallProcedure callProcedure = new CallProcedure();
				
		callProcedure.callProcedureNoParam();
		callProcedure.callProcedureInputParam("莲",88.88);
		callProcedure.callProcedureOutputParam(null,null);
		callProcedure.callInAndOutputParam("榴莲",null);
	}
	

}
