<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<style>
 #note {
 	border:1, solid, black;
 }
 
 input[type=text] {
 	width: 500px;
 	height: 500px;
 }

</style>
<link rel="stylesheet" href='<c:url value="/css/default.css"/>'>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<div id="note">
		<form action="<c:url value='/message/sendMessage.do'/>" method="post" enctype="multipart/form-data">
			<input type="text" name="idx" value="${loginMember.idx}">
			<table>
				<tr>
					<td>보내는 사람</td>
					<td><input type="email" name="senderId" id="noteId" value="${loginMember.uid}" readonly></td>
				</tr>
				<tr>
					<td>받는 사람</td>
					<td><input type="email" name="receiverId" id="noteId" required></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" name="noteText" required></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="file" name="noteImage"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="보내기"></td>
				</tr>
			</table>
		</form>
	</div>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>