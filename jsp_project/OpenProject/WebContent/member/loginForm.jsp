<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CookieBox cookieBox=new CookieBox(request);
	String val=null;
	String chk=null;
	if(cookieBox.exist("id")) {	
		val=cookieBox.getValue("id");
		chk="checked";
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/default.css">

<style>
body, div, h1, form {
	margin: 0;
	padding: 0;
}

h1 {
	margin: 15px;
}

#loginTable {
	margin: 10px auto;
}

td {
	padding: 10px;
}

#btn_submit {
	padding: 10px;
	background-color: beige;
	font-weight: bold;
	color: darkgreen;
	border: 1px solid #EEEEEE;
}
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<div>
		<form id="form" action="loginCookie.jsp" method="post">
			<table id="loginTable">
				<tr>
					<td>아이디(이메일)</td>
					<td><input type="text" name="id" id="id" value=<%=val %> required></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" id="pw" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="check" id="check" <%=chk%>> 아이디 저장</td>
				</tr>
				<tr>
					<td></td>
					<td><input id="btn_submit" type="submit" value="로그인"></td>
				</tr>

			</table>
		</form>

	</div>
	<%@ include file="/include/footer.jsp"%>
</body>

</html>