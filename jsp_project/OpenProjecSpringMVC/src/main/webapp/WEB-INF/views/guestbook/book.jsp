<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 커뮤니티</title>
<link rel="stylesheet" href='<c:url value="/css/default.css"/>'>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div>

	<h1>비회원 방명록</h1>
	<hr>
	<button><a href="/bookForm">글쓰기</a></button>
	<hr>
	<div class="bookList">
	
	
	</div>
</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>