	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/commons/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
<script src="${webResourceUrl}/jquery.min.js"></script>
<link href="${webResourceUrl}/resource/css/login.css" rel="stylesheet" type="text/css">

<script type="text/javascript">

function regist(){
	window.location.href=AppConfig.ctx+"/addShop.jsp";
}

$(function(){
	$("#login").click(function(){
		var username=$("#username").val();
		var password=$("#password").val();
		$.ajax({
		   	 url:AppConfig.ctx + "/admin/login.do",
	    	data:{"username":username,"password":password},
	    	type:"post",
		dataType:"json",
		 success:function(result){
			 console.log("测试");
			 if(result!=null){
				 console.log("测试请求成功");
				 
				 window.location.href=AppConfig.ctx + "/admin/show.do";
			 }
			 if(result.state==1){
				 alert("失败了");
				 window.location.href="http://www.baidu.com";
			 }
		 }	,
		   error:function(){
			 console.log("进入错误");
			 window.location.href="http://www.qq.com";
			 }	
		});
			
		
		
	});
	
	
});

</script>

 <script type="text/javascript">
        $(function(){
           $("#div1").hide(); //先让div隐藏
            $("#span1").click(function(){
                  $("#div1").fadeIn("slow");//淡入淡出效果 显示div

            });

            $("#close").click(function(){

                     $("#div1").fadeOut("slow");//淡入淡出效果 隐藏div

            })

        });

    </script>
</head>
<body>
   <% session.setAttribute("xixi", "测试session") ;%> 
    <% session.setAttribute("xixi", "测试session重复") ;%> 
   <% application.setAttribute("haha", "测试application"); %>
    <%=new java.util.Date() %><br/>
    <% String a="测试" ;
       String b="测试2";
    out.println(a);
    %><br/>
    <h1>${xixi}</h1>
    <input type="text" id="remenber" placeholder="测试记忆" /><br/>
    <input type="text" id="username" placeholder="请输入用户名" /><br/>
    <input type="password" id="password" placeholder="请输入密码" /><br/>
    <input type="button" id="regist" value='&nbsp注&nbsp册&nbsp' onclick="regist()"/>
    <input type="button" id="login" value='&nbsp登&nbsp录&nbsp'  "/>
    <input type="button" id="span1" value='&nbsp编&nbsp辑&nbsp'  "/>
   <% out.println(b); %><br/>
  <%-- 注释一下 --%>
 
  ${pageContext.request.contextPath}<br/>
  <div id="div1">
   <div  align="right" style="background-color:blank;"><span id="span2" style="cursor:pointer"></span>
   </div>
   <div id="div2">
   <input type="button" id="close" value="关闭"/>
   username:<input  type="text"/><p />
   &nbsp&nbsp&nbsp&nbsp&nbspage&nbsp:<input  type="text"/><p />
   <input type="button" id="edit" value='&nbsp提&nbsp交&nbsp' onclick="window.location.reload();"/>
   </div>
  </div>
</body>
</html>