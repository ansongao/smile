<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/commons/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/superman/jquery.min.js"></script>
   <style type="text/css">



#div1 {

 width:100%;  
    position:absolute;  
    background:#000;  
    z-index:998;
    top:0;  
    left:0;  
    height:2000px;
    opacity:0.6; 

}
</style>
 <script type="text/javascript">

        $(function(){

           $("#div1").hide(); //先让div隐藏

            $("#span1").click(function(){

                  $("#div1").fadeIn("slow");//淡入淡出效果 显示div

            });

            $("#span2").click(function(){

                     $("#div1").fadeOut("slow");//淡入淡出效果 隐藏div

            })

        });

    </script>

</head>
<body>
   <span style="cursor:pointer" id="span1">点我弹出div</span>

 <div id="div1">

   <div align="right" style="background-color:#CDCDCD;"><span id="span2" style="cursor:pointer">关闭</span>

   </div>

   <p><p>

<form>

username:<input  type="text"/><p />

age:<input  type="text"/><p />

<input  type="submit" value="提交"/><br />

</form>

</div>
</body>
</html>