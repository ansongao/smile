<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${webResourceUrl}/plugins/jquery.min.js"></script>
<script type="text/javascript" src="${webResourceUrl}/plugins/jquery.dataTables.js"></script>
<link rel="styleSheet" type="text/css" href="${webResourceUrl}/plugins/jquery.dataTables.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>插件测试</title>
<script type="text/javascript">
<!--：初始化Datatables-->
$(function () {
	 var data=[
	              {
	            	 "name":"1",
	            	 "position":"2",
	            	 "salary":"3",
	            	 "office":"4",
	              }
	              ,
	              {
		            	 "name":"1",
		            	 "position":"2",
		            	 "salary":"3",
		            	 "office":"4",
		              }
	              ]
	 
    $('#example').DataTable({
    	data:data,
    	columns:[
    	         {data:'name'},
    	         {data:'position'},
    	         {data:'salary'},
    	         {data:'office'}
    	         ]
    });

   $("#table_id_example").DataTable();
  
} );       
</script>

</head>
<body>
  <div class="col_2_3_right">  
                <div class="index_viewport">  
                    <table id="example" cellpadding="0" cellspacing="0" border="0" width="100%">  
                        <thead>  
                            <tr>  
                                <th width="20%">用户ID</th>  
                                <th width="30%">用户信息</th>  
                                <th width="30%">UID</th>  
                                <th width="20%">特殊别名</th>  
                            </tr>  
                        </thead>  
                    </table>  
                </div>  
            </div>  
            
            <div>
            -<br/>
            -<br/>
            -<br/>
            -<br/>
            -<br/>
            -<br/>
            -<br/>
            </div>
            <table id="table_id_example" class="display">  
        <thead>  
            <tr>  
                <th>Column 1</th>  
                <th>Column 2</th>  
            </tr>  
        </thead>  
        <tbody>  
            <tr>  
                <td>Row 1 Data 1</td>  
                <td>Row 1 Data 2</td>  
            </tr>  
            <tr>  
                <td>Row 2 Data 1</td>  
                <td>Row 2 Data 2</td>  
            </tr>  
        </tbody>  
    </table>  

</body>
</html>