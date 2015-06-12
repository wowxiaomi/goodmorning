<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="">
<form action="<%=request.getContextPath() %>/product/submitinfo.py" >
<label>MID:</label><input type="password" id="mid" name="mid"><br>
<label>商品名称:</label><input type="text" size="24" id="pname" name="pname"><br>
<label>商品价格:</label><input type="text" size="8" id="ppirce" name="ppirce"><br>
<label>商品描述:</label><textarea rows="15" cols="40" name="pdesc"></textarea><br>
<label>商品地址:</label><input type="url"  id="pimageurl" name="pimageurl"><br>
<label>商品渠道:</label><input type="text"  id="pchannel" name="pchannel"><br>
<label>商品图片:</label><input><br>
<input value='ok' type='submit' />
</form>
</div>
</body>
</html>