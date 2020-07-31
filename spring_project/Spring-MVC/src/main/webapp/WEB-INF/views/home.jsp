<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Spring MVC@
	</h1>

	<ul> 
		<li><a href="<c:url value='/hello' />">/hello</a></li>
		<li><a href="bye">/bye</a></li>
		<li><a href="<c:url value='/login/login' />">/loginForm(get)</a></li>
		<li><a href="<c:url value='/search' />">/search</a></li>
		<li><a href="<c:url value='/order/order' />">/order/order</a></li>
		
	</ul>
	
	
	
	
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
