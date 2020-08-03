<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 커뮤니티</title>
</head>
<body>
<c:if test="${loginMember==null }">
	<script>
		alert('로그인한 회원만 이용이 가능합니다.');
		location.href="<c:url value='/index'/>";
	</script>
</c:if>
<c:if test="${loginMember!=null }">

	<h1>회원제 게시판</h1>
	<hr>
	<button><a href="/boardForm">글쓰기</a></button>
	<hr>
	<table>
		<tr>
			<th>아이디</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="" >
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	
	
	
	
	
	
	
	

</c:if>

</body>
</html>