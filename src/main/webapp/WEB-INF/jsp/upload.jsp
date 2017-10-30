<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/commons/taglibs.jsp" %>
<html>
<head>
<script src="/superman/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
 
<script type="text/javascript">
   $(function(){
	   var message=${news}
       if(message!=null){
    	   alert(message);
       }	   
   });

</script>
</head>
<body>
   <div>
   <img src="D:/upload/33333.png" >  
   </div>
   <form action="${pageContext.request.contextPath}/admin/upload.do" method="post" enctype="multipart/form-data">
     上传用户：<input type="text" name="username"><br/>
    上传文件1：<input type="file" name="file1"><br/>
    <!--  上传文件2：<input type="file" name="file2"><br/>-->
   <input type="submit" value="提交">
   </form>
   <div style="position:relative;top:100px;">
  <%=request.getSession().getServletContext().getRealPath("/") %></br>
  <%String path=request.getServletContext().getRealPath("");
  
    String base=request.getContextPath().substring(1);
    
    String base2=path.substring(0, path.indexOf(base));
    
    int a=base2.lastIndexOf("\\");
    String base3=base2.substring(0,3);
    
    int b=base3.lastIndexOf("\\");
    String base4=base3.substring(0,b+1);
  %></br>
  
   
  
  <%=base %></br>
  <%=path.indexOf(base) %></br>
  <%=base4 %>
   </div>
   
   
</body>
</html>