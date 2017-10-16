package org.nercita.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormResubmitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5673054791105888856L;


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
		
        boolean flag = isTokenValid(request);  
        if(!flag){  
            System.out.println("请不要重复提交");  
            return;  
        }  
        System.out.println("向数据库中注册用户--------");  
        request.getSession().removeAttribute("token");
        
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

         doGet(request, response);
	}
	
	
    //验证表单提交是否有效，返回true，表示表单可以提交   
    public boolean isTokenValid(HttpServletRequest request){  
        //首先判断传递过来的表单号是否有效   
        String clientToken = request.getParameter("token"); 
        
        if(clientToken == null){  
            return false;  
        }  
          
        //然后再判断服务器端session域中是否有令牌信息了  
        String serverToken = (String)request.getSession().getAttribute("token");  
        System.out.println("session中保留的token为："+ serverToken);
        if(serverToken == null){  
            return false;  
        }  
          
        //在比较表单携带过来的随机数和session域中的令牌信息是否一致   
        if(!clientToken.equals(serverToken)){  
            return false;  
        }  
          
        return true;  
    }

}
