<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/commons/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table border="0" width="95%">
       <tr align="center">
          <td><h1>用户表</h1></td>
       </tr>
       <tr align="center">
          <td>
             <table>
               <tr align="center">
                 <td>用户ID</td>
                 <td>用户信息</td>
                 <td>UID</td>
                 <td>特殊别名</td>
               </tr>
             <c:forEach items="${requestScope.all}" var="user">
                <tr>
                  <td>${user.login_id}</td>
                  <td>${user.password}</td>
                  <td>${user.uid}</td>
                  <td>${user.uname}</td>
                </tr>
             </c:forEach>
               <tr align="center">
                  <td>当前页${page.currentPage}</td>
                  <td>总页数${page.totalPage}</td>
                </tr>
                <tr align="center">
             <c:choose>
               <c:when test="${page.hasPrePage}">
                  <td><a href= "/superman/admin/showPage.do?currentPage=1">首页</a></td>
                  <td><a href="/superman/admin/showPage.do?currentPage=${page.currentPage-1}">上一页</a></td>
               </c:when>
               <c:otherwise>
                  <td>首页</td>
                  <td>上一页</td>
               </c:otherwise>    
             </c:choose>
                  <c:forEach varStatus="i" begin="1" end="3">
                  <td><a href="/superman/admin/showPage.do?currentPage=${page.currentPage+i.count}">${page.currentPage+i.count}</a></td>
                  </c:forEach>
                 
             <c:choose>
                <c:when test="${page.hasNextPage}">
                   <td><a href="/superman/admin/showPage.do?currentPage=${page.currentPage+1}">下一页</a></td>
                   <td><a href="/superman/admin/showPage.do?currentPage=${page.totalPage}">尾页</a></td>
                </c:when>  
                <c:otherwise>
                   <td>下一页</td>
                   <td>尾页</td>
                </c:otherwise>          
             </c:choose>
            
             </tr>
             </table>
          
          </td>
       
       </tr>
          
    
    
    </table>
    <input type="text" runat="server"  id="test" name="test" placeholder="测试无刷新" value="结果"/>  
    <input type="button" name="play" value="测试"/>
</body>
</html>