<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트 관리</title>
<link rel="stylesheet" href='<c:url value="/css/default.css"/>'>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div>
		회원 리스트
		<hr>
		<c:if test="${memberListView.memberList!=null}">
		<table>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>가입일</th>
				<th>프로필 사진</th>
				<th>관리</th>
			</tr>
			<c:forEach items="${memberListView.memberList }" var="members">
				<tr>
					<td>${members.email}</td>
					<td>${members.pw }</td>
					<td>${members.name }</td>
					<td>${members.regdate }</td>
					<td><img src=<c:url value="${members.photoPath}"/> style="width: 50px;"></td>
					<td>수정 | 삭제</td>
				</tr>
			</c:forEach>

		</table>

		</c:if>
		<c:if test="${memberListView.memberList==null}">
			<h1>회원이 존재하지 않습니다.</h1>
		</c:if>
		<div>
			<c:forEach begin="1" end="${memberListView.pageTotalCount }" var="num">
				<a href="/memberList?page=${num}">[${num}]</a>
			</c:forEach>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>