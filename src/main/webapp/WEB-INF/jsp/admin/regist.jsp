<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/commons/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script src="${webResourceUrl}/jquery.min.js"></script>
<script type="text/javascript"
				src="${webResourceUrl}/resource/js/regist.js"></script>
<link href="${webResourceUrl}/resource/css/regist.css" rel="stylesheet" type="text/css">
</head>
<body>
   <p>${checkcode}</p>
   <h1>深酒网</h1>
   <div id="div1"><img src="${webResourceUrl}/resource/images/766971.jpg" /></div>
   <div class="regist_news">
   用户名：<input type="text" id="username" placeholder="输入用户名"><span id="user_input" class="user_input"></span><br/>
  密&nbsp码：<input type="password" id="password"  placeholder="清输入密码"><span id="pass_input" class="pass_input"></span><br/>
  邮&nbsp箱：<input type="text" id="email" placeholder="请输入邮箱地址"><br/>
  
       验证码：<input type="text" name="validateCode" id="validateCode"/>
    <img alt="验证码看不清，换一张" src="${webResourceUrl}/admin/createCode.do" id="validateCodeImg" onclick="changeImg(this,'ch')">   
    <!--  <a href="javascript:void(0)" onclick="changeImg(this,'ch')">看不清，换一张</a><br/>-->
    <span id="codeSpan" class="codeSpan"></span><br>        
   <input type="radio" name="sex" checked><span>男</span>
   <input type="radio" name="sex" ><span>女</span><br/>
       <span>喜欢喝的酒</span>
     <label><input name="Fruit" type="checkbox" value="" checked/>茅台 </label>
     <label><input name="Fruit" type="checkbox" value="" />深酒 </label>
     <label><input name="Fruit" type="checkbox" value="" />白兰地 </label>
     <label><input name="Fruit" type="checkbox" value="" />劲酒</label><br/>
       <span>喜欢的城市：</span>
   <select  id="citys" onchange="change(this);" >
      <option value="1">请选择</option>
      <option value="2">茅台</option>
      <option value="3">深酒</option>
      <option value="4">小鹏友</option>
   </select>
   
   <select id="selectTwo">
   </select>
   <span id="city_input" class="city_input"></span>
   </div>
   
   
   
   <div class="input">
   <!-- 文本输入框，可用做留言功能 -->
   <textarea rows="10" cols="30" id="textarea">留言</textarea><br/>
   
   <input type="button" id="regist" class="regist" value="注册"/><br/>
   </div>
   
</body>
</html>