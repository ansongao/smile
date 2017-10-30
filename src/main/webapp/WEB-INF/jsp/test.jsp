<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script type="text/javascript">
$(function() {
    var availableTags = [
      "James",
      "Kobe",
      "Jordan",
      "tom",
      "haha"
    ];
    $("#tags").autocomplete({
      source: availableTags
    });
  });

</script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/accept.do" method="get" >
         用户名：<input type="text" name="username" id="tags" /><br/> 
         <p></p>
         <p></p>
            密码：<input type="password" name="password"/><br/>
          <!--    <label for="tags">Tags: </label>
             <input id="tags"><br/>--> 
    <input type="submit" value="提交"/><br/>
    </form>
</body>
</html>