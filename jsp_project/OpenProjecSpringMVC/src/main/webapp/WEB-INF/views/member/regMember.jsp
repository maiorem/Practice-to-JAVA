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
</head>
<body>
	<c:if test="${regMember==null }">
		<script>
			alert('회원 가입에 실패하였습니다.');
			location.href="<c:url value='/index'/>";
		</script>
		
	</c:if>
	<c:if test="${regMember!=null }">
		<script>
			alert('회원 가입에 성공하였습니다.');
			location.href="<c:url value='/index'/>";
		</script>
	</c:if>
	
		

</body>
</html>