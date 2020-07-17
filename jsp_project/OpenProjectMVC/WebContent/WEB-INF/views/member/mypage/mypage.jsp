<%@page import="java.util.HashMap"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href='<c:url value="/css/default.css" />'>

<style>
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<c:if test="${loginMember!=null}">
	<div>
		<h1>마이페이지</h1>
		접속자 아이디 : ${loginMember.uid} <br>
		접속자 이름 : ${loginMember.uname} <br>
		회원 사진 <br>
		<img src=<c:url value="${loginMember.uphoto}"/> style="width:100px;">
		<br>
	</div>
	</c:if>
	
	<c:if test="${loginMember==null}">
		<script>
		alert('사용자 전용 페이지입니다. \n로그인해주세요.');
		location.href='<c:url value="/WEB-INT/views/member/loginForm.do"/>';
		</script>
	</c:if>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	
</body>
</html>
