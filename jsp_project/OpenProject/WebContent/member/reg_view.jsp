<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${memberResult>0}">
		<h1>회원 가입이 완료되었습니다.</h1>
	</c:if>
	<c:if test="${memberResult eq 0}">
		<h1>저장이 되지 않았습니다.</h1>
	</c:if>
	<a href="../index.html">첫페이지로</a>
</body>
</html>