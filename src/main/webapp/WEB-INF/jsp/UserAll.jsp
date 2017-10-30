<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/commons/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户表</title>
<script src="/superman/jquery.min.js"></script>
<script type="text/javascript" src="${webResourceUrl}/plugins/jquery.dataTables.js"></script>
<link rel="styleSheet" type="text/css" href="${webResourceUrl}/plugins/jquery.dataTables.css"/>
<script type="text/javascript">
$(function(){
	 $('#example').DataTable();
	
});
	
		
	function go(page){
			var input=$("#test1").val();
			var play=$("#pay").val();
			
		$.ajax({
			url:"/superman/admin/showPage1.do",
		   data:{"input":input,"pay":play,"currentPage":page},
		   type:"POST",
	   dataType:"JSON",
		success:function(result){
			if(result!=null){
				window.location.href ="/superman/admin/showPage2.do" ;
			}
		},
		 error:function(){
			 alert("系统异常");
		 }
			   
			
		
		});
	};	
	

	
	

</script>
</head>
<body>
    <table  border="0" width="95%">
       <tr align="center">
          <td><h1>用户表</h1></td>
          <a href= "/superman/admin/page.do">用户首页</a><br/>
          <a href= "/superman/admin/show.do">编辑</a><br/>
       </tr>
       <tr align="center">
          <td>
             <table id="example">
             <thead>
               <tr align="center">
                 <td >用户ID</td>
                 <td >用户信息</td>
                 <td >UID</td>
                 <td >特殊别名</td>
               </tr>
              </thead>
              <tbody>
             <c:forEach items="${requestScope.all}" var="user">
                <tr>
                  <td >${user.login_id}</td>
                  <td >${user.password}</td>
                  <td >${user.uid}</td>
                  <td >${user.uname}</td>
                </tr>
             </c:forEach>
             </tbody>
             </table>
             
               <tr align="center">
                  <td>当前页${page.currentPage}</td>
                  <td>总页数${page.totalPage}</td>
                </tr>
                <tr align="center">
             <c:choose>
               <c:when test="${page.hasPrePage}">
                  <td><a onclick="go(1);" href="javascript:void(0);">首页</a></td>
                  <td> <a onclick="go(${page.currentPage - 1});" href="javascript:void(0);">上一页</a></td>
               </c:when>
               <c:otherwise>
                  <td>首页</td>
                  <td>上一页</td>
               </c:otherwise>    
             </c:choose>
                  <c:forEach varStatus="i" begin="1" end="3">
                  <td><a onclick="go(${page.currentPage+i.count});" href="javascript:void(0);">${page.currentPage+i.count}</a></td>
                  </c:forEach>
                 
             <c:choose>
                <c:when test="${page.hasNextPage}">
                   <td><a onclick="go(${page.currentPage + 1});" href="javascript:void(0);">下一页</a></td>
                   <td><a onclick="go(${page.totalPage});" href="javascript:void(0);">尾页</a></td>
                </c:when>  
                <c:otherwise>
                   <td>下一页</td>
                   <td>尾页</td>
                </c:otherwise>          
             </c:choose>
            
             </tr>
             
          
          </td>
       
       </tr>
          
    
    
    </table>
    <input type="text"   id="test1" name="test2" placeholder="测试无刷新" value=${inputs}>  
    <input type="button" id="pay" name="play" value="测试"/>
</body>
</html>