<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
	<h1>Login Member</h1>
	<hr>
	<table border="1">
		<tr>
			<td>아이디(이메일)</td>
			<td>비밀번호</td>

		</tr>
		<tr>
			<td><%=request.getParameter("id") %></td>
			<td><%=request.getParameter("pw") %></td>

		</tr>
	</table>

</body>
</html>