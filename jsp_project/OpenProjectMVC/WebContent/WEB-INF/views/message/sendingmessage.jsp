<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<style></style>
</head>
<body>

	<c:if test="${note!=null}">
		메시지가 정상적으로 데이터베이스에 업로드 되었습니다.
		<c:forEach items="${note}" var="notes">
			보낸 사람 : ${notes.msg_writer}
			받은 사람 : ${notes.msg_receiver}
			메시지 <br>
			${notes.msg_text}
		</c:forEach>
	
	</c:if>
	<c:if test="${note==null }">
		메시지 업로드에 실패하였습니다.
	</c:if>
</body>
</html>