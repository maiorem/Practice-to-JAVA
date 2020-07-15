<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href='<c:url value="/css/default.css"/>'>
<style>
.currentPage {
	font-weight: bold;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div>
		<h1>회원 리스트</h1>
		<hr>
		<c:if test="${not empty memberListView.memberList}">
			<table border="1">
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>프로필사진</th>
					<th>가입날짜</th>
					<th>관리</th>
				</tr>
				<c:forEach items="${memberListView.memberList}" var="members">
					<tr>
						<td>${members.idx}</td>
						<td>${members.uid}</td>
						<td>${members.uname}</td>
						<td><img src=<c:url value="${members.uphoto}"/>
							style="width: 100px;"></td>
						<td>${members.regdate}</td>
						<td><a href="editMemberSelect.do?uid=${members.uid}">수정</a> |
							<a href="deleteMember.do?uid=${members.uid}">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>


		<c:if test="${empty memberListView.memberList}">

			<h3>회원이 존재하지 않습니다.</h3>

		</c:if>
		<div>
			<c:forEach begin="1" end="${memberListView.pageTotalCount}" var="num">
				<a href="memberList.do?page=${num}"
					${listView.currentPageNumber eq num ? 'class="currentPage"' : '' }>[${num}]</a>
			</c:forEach>
		</div>

	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>