<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/commons/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>深酒</title>
<script src="${webResourceUrl}/jquery.min.js"></script>
<link href="${webResourceUrl}/resource/css/shop.css" rel="stylesheet" type="text/css">
<script src="${webResourceUrl}/resource/js/shop.js"></script>

</head>
<body>
      
       <h1 class="welcome" >欢迎来到深酒</h1>
        <div class="search">
        <input type="text" class="search_input" id="input" placeholder="请输入要搜素的内容">
        <input type="button" class="search_button" id="search"value="搜素">
        <div class="login1"> 
        <input type="button"  class="login2"value="登录">
        <input type="button" id="regist" value="注册">
       <input type="button" value="购物车">
       </div>
        </div>
        
      <div class="cat">
      <img  src="${webResourceUrl}/resource/images/TB1eREfLVXXXXaHXFXXXXXXXXXX-480-260.png">
      </div>
      
      <div class="shenjiu1">
      <img src="${webResourceUrl}/resource/images/shenjiu.jpg">
      </div>
      <div class="music">
     <!--   <embed src="${webResourceUrl}/sss.mp3" loop="11" autostar="true">--> 
      </div>
      <!-- 进入订单列表 -->
      <div class="order">
      <%@ include file="include/order.jsp" %>
      </div>
      <!-- 前端图片 -->
      <div class="other">
      <%@ include file="include/shenjiu.jsp" %>
      </div>
      
     
    

</body>
</html>