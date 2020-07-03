<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberInfo memInfo=(MemberInfo) session.getAttribute("member");
%>
<%
	if(memInfo!=null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 게시판</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/default.css">

<style>
	
</style>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<div>
		<h1>게시판</h1>
	</div>
	<%@ include file="/include/footer.jsp" %>
</body>
</html>
<% 
	} else {
%>
<script>
	alert('회원 전용 페이지입니다.');
	location.href='<%=request.getContextPath()%>/member/loginForm.jsp';
</script>
<%
}
%>