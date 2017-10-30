
$(function(){
		$("#search").click(function(){
		var inputs=$("#input").val();
		console.log(inputs);
			if(inputs!=""){
			alert("别点，疼");
			}
		});
	
		$("#regist").click(function(){
			window.open(AppConfig.ctx+"/admin/regist.do");
			
		});
	
	
});

