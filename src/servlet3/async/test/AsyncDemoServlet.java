package servlet3.async.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/test/asyncDemoServlet")
public class AsyncDemoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7014449814826530037L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");  
        PrintWriter out = resp.getWriter();  
        out.println("进入Servlet的时间：" + new Date() + ".");  
        out.flush();  
  
        //在子线程中执行业务调用，并由其负责输出响应，主线程退出   
        AsyncContext ctx = req.startAsync();  
        new Thread(new Executor(ctx)).start();  
  
        out.println("结束Servlet的时间：" + new Date() + ".");  
        out.flush();  
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	
	

}
