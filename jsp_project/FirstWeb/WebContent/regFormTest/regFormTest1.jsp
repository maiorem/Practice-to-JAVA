<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member</h1>
	<hr>
	<table>
		<tr>
			<td>아이디(이메일)</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>사진</td>
		</tr>
		<tr>
			<td><%=request.getParameter("id") %></td>
			<td><%=request.getParameter("pw") %></td>
			<td><%=request.getParameter("userName") %></td>
			<td><img src="<%=request.getParameter("userPhoto") %>"></td>
		</tr>
	</table>

</body>
</html>