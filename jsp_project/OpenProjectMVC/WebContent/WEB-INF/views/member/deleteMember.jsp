<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 완료 페이지</title>
<link rel="stylesheet" href='<c:url value="/css/default.css"/>'>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div>
	<c:if test="${deleteCode==-1}">
		<h1>삭제 할 메시지가 존재하지 않습니다.</h1>
	</c:if>
	<c:if test="${deleteCode==-2}">
		<h2>아이디가 일치하지 않습니다.</h2>
	</c:if>
	<c:if test="${deleteCode==1}">
		<h1>메시지가 정상적으로 삭제되었습니다.</h1>
	</c:if>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>