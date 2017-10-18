<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/include.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>纪念日助手</title>
<script>

</script>
</head>
<body>
	<center><h1>我的个人信息</h1></center>
	<img src="${requestScope.user.headimgurl}" height="200" width="200">
	<p>名字:${requestScope.user.nickname}</p>
	<p>国籍:${requestScope.user.country}</p>
	<p>省份:${requestScope.user.province}</p>
</body>
</html>