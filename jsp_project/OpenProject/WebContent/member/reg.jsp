<%@page import="member.service.MemberInfoService"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="requestMember" class="model.MemberInfo" scope="request"></jsp:useBean>
<<jsp:setProperty property="*" name="requestMember"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>

<link rel="stylesheet" href='<c:url value="/css/default.css"/>'>

<style>
	
</style>
</head>
<body>
<%
	MemberInfoService service=MemberInfoService.getInstance();
	int result=service.createMember(requestMember);
	request.setAttribute("member", result);
%>
<jsp:forward page="loginForm.jsp"></jsp:forward>
</body>
</html>