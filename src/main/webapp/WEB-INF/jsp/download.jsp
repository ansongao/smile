<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${webResourceUrl}/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载页面</title>
<%String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();%>
<% request.setAttribute("path", path); %>
</head>
<body>
     <h1>测试  ${path}   <%=request.getServletContext() %></h1>
     <!-- 遍历map集合 -->
     <c:forEach items="${fileNameMap}" var="me">
       <c:url value="${path}/admin/download.do" var="downurl">
           <c:param name="fileName" value="${me.key}"></c:param>
       </c:url>
         <img alt="haha" src="${downurl}" width="200",height="200">
         ${me.value}&nbsp&nbsp<a href="${downurl}">下载&nbsp&nbsp${downurl}</a> <br/>
     </c:forEach>
     <div>
     <a href="?a=1">跳转</a>
     </div>
</body>
</html>