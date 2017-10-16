package org.nercita.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {

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
		
		getCookies(request, response);


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
	
	
	//显示上次访问的时间
	public void getCookies(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//设置编码   
        response.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8");  
        PrintWriter out = response.getWriter();  
        out.print("你上一次访问的时间是:");  
          
/*        //获得用户的时间cookie,并且获取值，如果第一次的话，是没有Cookie信息的，所以Cookie数组可能为null,所以我们要做判断   
        Cookie cookies[] = request.getCookies();  
        for(int i=0;cookies != null && i<cookies.length;i++){  
            if(cookies[i].getName().equals("lastAccessTime")){  
                long cookieValue = Long.parseLong(cookies[i].getValue());  
                Date date = new Date(cookieValue);  
                out.print(date.toLocaleString());  
            }  
        }*/  
          
/*        //创建每次访问的时候，我们都会回写一个Cookie给客户机，并且将Cookie的有效期设置为30天,路径设置成整个web应用   
        Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");  
        cookie.setMaxAge(30*24*3600);  
        cookie.setPath("/testWeb");  
        response.addCookie(cookie); */ 

		
	}

}
