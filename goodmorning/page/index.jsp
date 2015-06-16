<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(function(){
	//top5
	$.ajax({
		type: "get",//使用get方法访问后台
	    dataType: "json",//返回json格式的数据
	    url: "/goodmorning/product/findHotTop5.py",//要访问的后台地址
	    data: "",//要发送的数据
	    complete :function(){},//AJAX请求完成时隐藏loading提示
	    success: function(msg){//msg为返回的数据，在这里做数据绑定
		for(x in msg){
			alert(msg[x].pName+"  "+msg[x].price);
		}			

	    },
	    error:function(data){
	    	alert(data['responseText']);
	    }
	});
	
	//new products
	$.ajax({
		type: "get",//使用get方法访问后台
	    dataType: "json",//返回json格式的数据
	    url: "/goodmorning/product/queryProductlist.py",//要访问的后台地址
	    data: "",//要发送的数据
	    complete :function(){},//AJAX请求完成时隐藏loading提示
	    success: function(msg){//msg为返回的数据，在这里做数据绑定
			alert(msg.totalCount);
	    	alert(msg.datas[1].mId);
	    },
	    error:function(data){
	    	alert(data['responseText']);
	    }
	});
}	
);

</script>
</head>
<body>

</body>
</html>