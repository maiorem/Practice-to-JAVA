<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<style></style>
<link rel="stylesheet" href='<c:url value="/css/default.css"/>'>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>


	<c:if test="${noteList.messageList != null}">
		<table border="1">
			<tr>
				<th>No.</th>
				<th>보낸이</th>
				<th>메시지</th>
				<th>이미지</th>
				<th>날짜</th>
				<th>읽음</th>
			</tr>
			<c:forEach items="${noteList.messageList}" var="notes">
				<c:if test="${loginMember.uid eq notes.msg_receiver}">
					<tr>
						<td>${notes.msg_idx}</td>
						<td>${notes.msg_writer}</td>
						<td>${notes.msg_text}</td>
						<td><img src=<c:url value="${notes.msg_img}"/>
							style="width: 100px;"></td>
						<td>${notes.msg_date}</td>
						<td>${notes.msg_readcheck }</td>
					</tr>
				</c:if>
			</c:forEach>
	</c:if>




	<c:if test="${noteList.messageList==null}">

		<h3>쪽지가 존재하지 않습니다.</h3>

	</c:if>
	<div>
		<c:forEach begin="1" end="${noteList.pageTotalCount}" var="num">
			<a href="messageList.do?page=${num}"
				${noteList.currentPageNumber eq num ? 'class="currentPage"' : '' }>[${num}]</a>
		</c:forEach>
	</div>

	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>