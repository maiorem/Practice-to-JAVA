<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%
	session.invalidate();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 확인 페이지</title>
<link rel="stylesheet" href='<c:url value="/css/default.css"/>'>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div>
	<h1>회원</h1>
	<hr>	
	<h3>
	<c:if test="${empty loginMember}">
		<div>
		정상적으로 로그아웃을 완료하였습니다
		</div>
	</c:if>
	<c:if test="${not empty loginMember}">
		로그아웃 실패
	</c:if>
	</h3>
		
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>