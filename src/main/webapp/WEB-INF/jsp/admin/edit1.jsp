<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/commons/taglibs.jsp" %>
<html>
<head>
<title>无标题文档</title>
<script type="text/javascript"> 
function ShopConfirm(str){ 
	var ShopConfirmLayer=document.getElementByIdx_x(str);
	var webBgLayer=document.getElementByIdx_x("webBgLayer");
	// ShopConfirmLayer.innerHTML=str; ShopConfirmLayer.style.display="";
	//显示内容层，显示覆盖层
	ShopConfirmLayer.style.left=parseInt((document.documentElement.scrollWidth-ShopConfirmLayer.offsetWidth)/2)+document.documentElement.scrollLeft+"px"; 
	ShopConfirmLayer.style.top=Math.abs(parseInt((document.documentElement.clientHeight-ShopConfirmLayer.offsetHeight)/2))+document.documentElement.scrollTop+"px"; 
	//为内容层设置位置 
	webBgLayer.style.display="";
	webBgLayer.style.height=document.documentElement.scrollHeight+"px";
	//为覆盖层设置高度
	} 
	function CloseShopConfirm(ids){
		var ShopConfirmLayer=document.getElementByIdx_x(ids);
		var webBgLayer=document.getElementByIdx_x("webBgLayer");
		ShopConfirmLayer.style.display="none";
		webBgLayer.style.display="none"; 
		} 
	function hide(id) { 
		var ids=document.getElementByIdx_x(id);
		ids.style.display='none';
		} 
	</script>
</head>
<body style="height: 95%;">
	<input type="button" value="test" onclick="ShopConfirm('img3')" />
	<div id="img3"
		style="position: absolute; top: 343px; left: 129px; background: #F7ECF9; font-size: 14px; color: black; z-index: 900; border: 2px #FFCC00 solid; width: 350px; height: 220px; padding: 9px;">
		<div style="width: 350px; text-align: right;">
			<div
				style="color: #9900CC; font-weight: bold; font-size: 15px; cursor: hand;"
				onclick="CloseShopConfirm('img3')">关 闭</div>
		</div>
		<br />
		<br />
		<br />
		<br />
		<br /> 在这里设置注册按钮
	</div>
	</div>
	<script language="javascript">hide('img3');</script>
	<div id="webBgLayer"
		style="position: absolute; top: 0px; left: 0px; z-index: 899; background-color: black; height: 100%; width: 100%; display: none; -moz-opacity: 0.9; filter: alpha(opacity = 50);"></div>
</body>
</html>