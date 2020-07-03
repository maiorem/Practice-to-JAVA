<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	request.setCharacterEncoding("utf-8");
%>
<%
	HashMap<String, MemberInfo> info=new HashMap<>();
	
	String uid=request.getParameter("uid");
	String upw=request.getParameter("upw");
	String username=request.getParameter("userName");
	String userphoto=request.getParameter("userPhoto");
	
	info.put(uid, new MemberInfo(uid, upw, username, userphoto));
	application.setAttribute(uid, info);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/default.css">

<style>
	
</style>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<div>
		<h1>회원가입이 완료되었습니다.</h1>
		
		<a href="<%=request.getContextPath() %>/member/loginForm.jsp">로그인 화면으로</a>
    
	</div>
	<%@ include file="/include/footer.jsp" %>
</body>
</html>