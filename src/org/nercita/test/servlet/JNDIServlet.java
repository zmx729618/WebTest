package org.nercita.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.Future;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jdbc.pool.DataSource;

public class JNDIServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4063005588610103364L;
	
	
	final String JNDINAME = "java:comp/env/jdbc/testweb" ;


	/**
	 * Constructor of the object.
	 */
	public JNDIServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	        doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
        try {
			// 初始化查找命名空间
			Context ctx = new InitialContext() ;
			// 找到DataSource
			DataSource datasource = (DataSource)ctx.lookup(JNDINAME) ;
            Connection conn = null;  

            //异步获取数据库连接
            Future<Connection> future = datasource.getConnectionAsync();  

		    while (!future.isDone()) { 
		       System.out.println("Connection is not yet available. Do some background work"); 
		       try { 
		          Thread.sleep(100); //simulate work 
		       }catch (InterruptedException x) { 
		           Thread.currentThread().interrupted(); 
		
		      } 
		
		   } 
		   conn = future.get(); //should return instantly 
		   Statement st = conn.createStatement(); 
		   ResultSet rs = st.executeQuery("select * from test"); 
		   int cnt = 1; 
	       while (rs.next()) { 
	           System.out.println((cnt++)+". Host:" +rs.getString("name")); 
	       } 
	       rs.close(); 
	       st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
