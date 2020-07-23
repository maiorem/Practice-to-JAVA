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
				<th>답장하기</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${noteList.messageList}" var="notes">
				<c:if test="${loginMember.uid eq notes.msg_receiver}">
					<tr>
						<td>${notes.msg_idx}</td>
						<td>${notes.msg_writerId}</td>
						<td><a>${notes.msg_text}</a></td>
						<td><img src=<c:url value="${notes.msg_img}"/>
							style="width: 100px;"></td>
						<td>${notes.msg_date}</td>
						<td><a href="repMessage.do?toPerson=${notes.msg_writerId}">답장</a></td>
						<td><a href="">삭제</a></td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
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