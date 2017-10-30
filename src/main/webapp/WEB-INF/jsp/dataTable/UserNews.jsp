<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${webResourceUrl}/plugins/jquery.min.js"></script>
<script type="text/javascript" src="${webResourceUrl}/plugins/jquery.dataTables.js"></script>
<!-- <script src="${webResourceUrl}/plugins/jquery.dataTables.custom.js"></script>  -->
<link rel="styleSheet" type="text/css" href="${webResourceUrl}/plugins/jquery.dataTables.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
<script type="text/javascript">

$(document).ready(function() {
    $('#example').DataTable( {
    	"ajax": "${webResourceUrl}/admin/dataTable.do",
        "columns": [
            { "data": "uname" },
            { "data": "password" },
            { "data": "login_id" },
            { "data": "uid" }
        ]
    } );
} );


function go(page){
	
	console.log(page);
$.ajax({
	url:"${webResourceUrl}/admin/dataTable.do",
   data:{"currentPage":page},
   type:"POST",
dataType:"JSON",
success:function(result){
	if(result!=null){
		window.location.herf="${webResourceUrl}/admin/dataShow.do"
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
     <table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Extn.</th>
            </tr>
        </thead>
 
        <tfoot>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Extn.</th>
            </tr>
        </tfoot>
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
</body>
</html>