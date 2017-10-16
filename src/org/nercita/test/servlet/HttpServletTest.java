package org.nercita.test.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletTest extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8694476634020269908L;

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
		
		
 
        try {
            //test1(response);//location响应头   
            //test2(response);//Content-Encoding响应头   
            //test3(response);//Content-Type响应头  
			test4(response); //refresh响应头
			//test5(response);//content-disposition
		} catch (Exception e) {

			e.printStackTrace();
		}   
        


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
		doGet( request, response);


	}
	
	//使用响应头location和302状态码实现请求重定向(地址栏中的地址发生改变)   
    public void test1(HttpServletResponse response){  
        response.setStatus(302);  
        response.setHeader("Location", "/index.html");  
    }  
      
    //使用响应头Content-Encoding实现数据的压缩输出   
    public void test2(HttpServletResponse resp) throws Exception{  
        //压缩数据很大的时候压缩效率才有体现，如果数据很小的话反而更大   
        //压缩资源：提高网页的访问性能,电信按照出口流量收钱的。   
        String data = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";//压缩数据大点还有效果   
        System.out.println("压缩前的数据大小:"+data.length());  
        ByteArrayOutputStream bout = new ByteArrayOutputStream();//底层流   
        GZIPOutputStream gout = new GZIPOutputStream(bout);//包装流一般有缓冲，没有把缓冲区写满，不会写到底层流   
        gout.write(data.getBytes());  
        gout.close();//等于刷新操作，将包装流中的信息刷新   
          
        byte gzip[] = bout.toByteArray();//得到压缩后的数据   
          
        System.out.println("压缩后的数据大小:"+gzip.length);  
          
        //通知浏览器数据采用压缩格式   
        resp.setHeader("Content-Encoding", "gzip");  
        resp.setHeader("Content-Length", gzip.length+"");//表明长度   
        resp.getOutputStream().write(gzip);//压缩数据写给浏览器   
    }  
      
    //使用响应头content-type设置服务器返回给client的数据类型   
    public void test3(HttpServletResponse resp) throws Exception{  
        //具体可以查看tomcat目录中的web.xml文件   
        resp.setHeader("Content-Type","image/jpeg");  
        InputStream ins = this.getServletContext().getResourceAsStream("/1.jpg");  
        int len = 0;  
        byte[] buffer = new byte[1024];  
        OutputStream ops = resp.getOutputStream();  
        while((len = ins.read(buffer))!=-1){  
            ops.write(buffer, 0, len);  
        }  
        ops.close();  
    }  
      
    //使用响应头refresh实现页面的定时刷新   
    public void test4(HttpServletResponse resp) throws Exception{  
        //股票，聊天室   
          
        //填充的值为:3;url="http://www.baidu.com"表示3s之后跳转到http://www.baidu.com页面   
        //如果没有http://www.baidu.com的话，只是在该页面进行刷新   
        resp.setHeader("refresh", "3;url=\"http://www.baidu.com\"");  
        String data = "aaaaaaaaaaaaaa";  
        resp.getOutputStream().write(data.getBytes());  
    }  
      
    //使用响应头content-disposition实现客户机用下载的方式打开数据资源   
    public void test5(HttpServletResponse resp) throws Exception{  
        resp.setHeader("content-disposition","attachment;filename=1.jpg");  
        InputStream ins = this.getServletContext().getResourceAsStream("/1.jpg");  
        int len = 0;  
        byte[] buffer = new byte[1024];  
        OutputStream ops = resp.getOutputStream();  
        while((len = ins.read(buffer))!=-1){  
            ops.write(buffer, 0, len);  
        }  
    }  


}
