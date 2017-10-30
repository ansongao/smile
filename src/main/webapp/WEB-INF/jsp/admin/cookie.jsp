<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/commons/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${webResourceUrl}/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#remove").click(function(){
		$.post(AppConfig.ctx+"/admin/remove.do",function(){
			alert("清除成功");
		});
		
	});
	
});

</script>
</head>
<body>
      <p>cookie设定</p>
      <p>${input}</p>
      <p>${show}</p>
      <input type="button" value="清除cookie" id="remove"/>
</body>
</html>