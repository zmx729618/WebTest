<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="./js/jquery.js"></script>

  </head>
  <body>
     <%  
   System.out.println(session.getId()); 
   out.println("<br> SESSION ID:" + session.getId()+"<br>");   
   // 如果有新的请求，则添加session属性 
   String name = request.getParameter("name"); 
   if (name != null && name.length() > 0) { 
      String value = request.getParameter("value"); 
      session.setAttribute(name, value); 
   }   
     out.print("<b>Session List:</b>");   
     Enumeration<String> names = session.getAttributeNames(); 
     while (names.hasMoreElements()) { 
         String sname = names.nextElement();  
         String value = session.getAttribute(sname).toString(); 
         out.println( sname + " = " + value+"<br>"); 
         System.out.println( sname + " = " + value); 
    } 
 %> 
     <form method="post" action="http://localhost:8080/testWeb/servlet/fileUploadServlet" enctype="multipart/form-data">
     
                                        标题： <input type="text"  name="title"/><br />
                                        文件：<input type="file"  name="file"/><br />
              <input type="submit" value="提交">                             
     
     </form>
  </body>
</html>
