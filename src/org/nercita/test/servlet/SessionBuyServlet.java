package org.nercita.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionBuyServlet extends HttpServlet {

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

		HttpSession session = request.getSession();  
		System.out.println("SessionObject:"+session);  
		System.out.println("SessionId:"+session.getId());
		
		
		
        //购买了一件物品，将这个物品存入到session中，然后将这个sessionid回写到客户机，有效时间是30分钟   
        session.setAttribute("store", "air-confication");  
        Cookie cookie = new Cookie("JSESSIONID",session.getId());//把系统的session id的覆盖掉   
        cookie.setMaxAge(30*360);  
        cookie.setPath("/testWeb");  
        response.addCookie(cookie);
		 
     /*   //获得用户的时间cookie,并且获取值，如果第一次的话，是没有Cookie信息的，所以Cookie数组可能为null,所以我们要做判断   
        Cookie cookies[] = request.getCookies();  
        for(int i=0;cookies != null && i<cookies.length;i++){  
            if(cookies[i].getName().equals("JSESSIONID")){  
                long cookieValue = Long.parseLong(cookies[i].getValue());  
   
            }  
        }*/
		
	/*	Cookie cookie = new Cookie("JSESSIONID",session.getId());//把系统的session id的覆盖掉   
		cookie.setPath("/testWeb");   
		cookie.setMaxAge(30*360);//30分钟，因为session的生命周期是30分钟   
		response.addCookie(cookie);*/
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

}
