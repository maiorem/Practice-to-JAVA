<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${writeMessage>0}">
		방명록 업로드 완료
	</c:if>
	<c:if test="${writeMessage==0}">
		업로드 실패
	</c:if>
	<a href="list.jsp">목록 보기</a>
</body>
</html>