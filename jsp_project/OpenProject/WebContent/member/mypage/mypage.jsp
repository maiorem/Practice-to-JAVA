<%@page import="model.MemberInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	MemberInfo memInfo=(MemberInfo) session.getAttribute("member");
	MemberInfo info=(MemberInfo) application.getAttribute("info");

	if(memInfo!=null) {
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/default.css">

<style>
</style>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<div>
		<h1>마이페이지</h1>
		접속자 아이디 : <%=info.getUid() %> <br>
		접속자 이름 : <%=info.getUsername() %>
		<br>

	</div>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>
<% 
} else {
%>
<script>
	alert('사용자 전용 페이지입니다. \n로그인해주세요.');
	location.href='<%=request.getContextPath()%>/member/loginForm.jsp';
</script>
<%
}
%>