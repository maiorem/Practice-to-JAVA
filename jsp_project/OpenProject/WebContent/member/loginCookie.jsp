<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
	String uid=request.getParameter("id");
	String upw=request.getParameter("pw");
	String ucheck=request.getParameter("check");
	
	if(uid!=null && upw!=null && ucheck!=null) {
		response.addCookie(CookieBox.createCookie("id", uid, "/op/", 3600));
	} 
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/default.css">

</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<div>
		<h1>로그인 완료</h1>
		id : <%=uid %>
		<br>
		pw : <%=upw %>
		
	</div>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>