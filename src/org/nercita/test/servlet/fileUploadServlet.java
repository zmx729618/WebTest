package org.nercita.test.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class fileUploadServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2439009281693860320L;

	public void destroy() {
		super.destroy();
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

              this.doPost(request, response);
              
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
		request.setCharacterEncoding("utf-8");
		boolean isMultipart =  ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			FileItemFactory itemFactory = new DiskFileItemFactory();
			ServletFileUpload fileUpload =  new ServletFileUpload(itemFactory);
			String dir = request.getSession().getServletContext().getRealPath("/uploadfiles");
			File dirFile = new File(dir);
			if(!dirFile.exists()){dirFile.mkdir();}
			
			try {
				List<FileItem> list  =  fileUpload.parseRequest(request);				
				for(FileItem item : list ){
					if(item.isFormField()){ //form表单域-文本
						String name = item.getFieldName();
					    String value = item.getString(); 
					    System.out.println(name+"="+value);
					}else{ //form表单域-文件
						System.out.println(dir);
						File saveFile = new File(dir,item.getName());
						item.write(saveFile);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
