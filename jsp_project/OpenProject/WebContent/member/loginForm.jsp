<%@page import="model.MemberInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	CookieBox cookieBox=new CookieBox(request);
	String val="";
	String chk="";
	if(cookieBox.exist("id")) {	
		val=cookieBox.getValue("id");
		chk="checked";
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<title>로그인 페이지</title>

<link rel="stylesheet" href='<c:url value="/css/default.css"/>'>

<style>

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
		<form id="form" action="login.jsp" method="post">
			<table id="loginTable">
				<tr>
					<td>아이디(이메일)</td>
					<td><input type="text" name="id" id="id" required value=${val} ></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" id="pw" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="check" id="check" ${chk}> 아이디 저장</td>
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