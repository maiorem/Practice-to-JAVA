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
		방명록 업로드
	</c:if>
	<c:if test="${writeMessage==0}">
		업로드 실패
	</c:if>
</body>
</html>