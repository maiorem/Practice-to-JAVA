<%@page import="model.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//String mId=(String) session.getAttribute("memberId");
	
	MemberInfo memberInfo=(MemberInfo) session.getAttribute("memberInfo");

	if(memberInfo==null) {
		//response.sendRedirect("sessionLoginForm.jsp");
		%>
		<script>
			alert('사용자 전용 페이지입니다. \n로그인해주세요.');
			location.href='sessionLoginForm.jsp';
		</script>
		<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 페이지</title>
</head>
<body>
	<h1>로그인을 한 사용자를 위한 페이지입니다</h1>
	<h3>로그인 아이디 : <%=memberInfo.getUid() %></h3> 
	<a href="logout.jsp">Logout</a>
	
</body>
</html>