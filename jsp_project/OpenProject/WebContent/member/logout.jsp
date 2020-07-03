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
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/default.css">
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h1>로그아웃 되셨습니다.</h1>
	<script>
		$('#loginChk').attr('href', '<%=request.getContextPath() %>/member/loginForm.jsp');
		$('#loginChk').text('로그인');
	</script>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>