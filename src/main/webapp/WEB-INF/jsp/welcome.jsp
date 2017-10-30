<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/commons/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
<script src="/superman/jquery.min.js"></script>
<script type="text/javascript">
function go(){
	window.location.href=AppConfig.ctx+"/addShop.jsp";
}
function show(){
	window.location.href=AppConfig.ctx+"/admin/check.do";
}
function back(){
	window.history.back(-1)
}

</script>

</head>
<body>
   
     <% String ha=(String)application.getAttribute("haha"); %>
     
     <h1><%=ha %></h1>
     <h1>${xixi}</h1>
    <h1>测试 </h1>
 <input type="button" id="add" value='&nbsp注&nbsp册&nbsp' onclick="go()"/><br>
 <input type="button" id="get" value='&nbsp登&nbsp录&nbsp' onclick="show()"/><br>
 <h1>AppConfig.ctx</h1>
 <input type="button" id="back" value='&nbsp返&nbsp回&nbsp' onclick="back()"/><br>
</body>
</html>