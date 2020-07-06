<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>

</head>
<body>

	
	<h1>로그아웃 되셨습니다.</h1>
	<a href='<c:url value="/index.jsp"/>'>처음으로</a>
	

</body>
</html>