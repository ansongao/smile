$(function(){
	   $("#selectTwo").hide();
	   $("#regist").click(function(){
		   //先清除提示
		   $("#user_input").html("");
		   $("#pass_input").html("");
		   $("#city_input").html("");
		   $("#codeSpan").html("");
			  var username=$("#username").val();
			  var password=$("#password").val();
			  var email=$("#email").val();
			  var citys=$("#citys").val();
			  var code=$("#validateCode").val();
			  console.log(code);
			  var index=true;
			  var textarea=$("#textarea").val();
			if(username==""){
				$("#user_input").html("用户名不能为空");
				index=false;
			}  
            if(password==""){
         	$("#pass_input").html("密码不能为空");
         	    index=false;
            }			  
			if(citys==1){
				$("#city_input").html("请选择城市");
				index=false;
			}
			if(code==""){
				$("#codeSpan").html("验证码不能为空");
				index=false;
			}
			if(index){
				url_=AppConfig.ctx+"/regist/checked.do";
				$.ajax({
					url: url_,
				   data: {"username":username,"password":password,"email":email,"code":code},
				   type:"get",
			   dataType:"json",
				 success:function(result){
					 console.log(result.state);
					 if(result.state==true){
						 alert("注册成功");
					 }else if(result.state==false){
						 alert("用户名已被注册");
					 }else{
						 alert("验证码错误");
					 }
					 console.log(result.state);
				 },
				  error:function(){
					  alert("注册失败");
				  }
				   
				});
			}
			
		  });
		  
});
	 
	  function change(city){
		  $("#city_input").html("");
		  $("#selectTwo").show();
		  var now=$("#citys").val();
		  if(now==2){
			  $("#selectTwo").empty();
			  $("#selectTwo").append('<option value="1">北京</option>'); 
			  $("#selectTwo").append('<option value="2">南京</option>'); 
			  $("#selectTwo").append('<option value="3">天津</option>'); 
		  }else if(now==3){
			  $("#selectTwo").empty();
			  $("#selectTwo").append('<option value="1">上海</option>'); 
			  $("#selectTwo").append('<option value="2">日本</option>'); 
			  $("#selectTwo").append('<option value="3">东京</option>'); 
		  }else if(now==4){
			  $("#selectTwo").empty();
			  $("#selectTwo").append('<option value="1">杭州</option>'); 
			  $("#selectTwo").append('<option value="2">厦门</option>'); 
			  $("#selectTwo").append('<option value="3">广州</option>'); 
		  }else{
			  $("#selectTwo").hide();
		  }
		
	  } 
	  
	
	      function changeImg(obj,createTypeFlag){
	       document.getElementById(obj.id).src="http://localhost:8080/superman/admin/createCode.do?createTypeFlag="+createTypeFlag+"&"+Math.random();
	     }

