<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CookieBox cookieBox=new CookieBox(request);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/default.css">

<style>
	
</style>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<div>
		<h1>마이페이지</h1>
		현재 접속자 : <%=cookieBox.getValue("id") %>
	</div>
	<%@ include file="/include/footer.jsp" %>
</body>
</html>