<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/default.css">
<style>
	table td {
		padding: 10px;
	}
	
	input, textarea {
		padding: 5px;
	}

</style>
<style>
	
</style>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<div>
		<h1>방명록</h1>
		<hr>
			<form action="messageWrite.jsp" method="post">
		<table>
			<tr>
				<td><label for="uname">이름</label></td>
				<td><input type="text" id="uname" name="uname" required></td>
			</tr>
			<tr>
				<td><label for="pw">비밀번호</label></td>
				<td><input type="password" id="pw" name="pw" required></td>
			</tr>
			<tr>
				<td><label for="message">메시지</label></td>
				<td><textarea rows="10" cols="20" name="message" id="message" required></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="글쓰기">
				 	<input	type="reset">
				 </td>
			</tr>
		</table>
	</form>
	</div>
	<%@ include file="/include/footer.jsp" %>
</body>
</html>