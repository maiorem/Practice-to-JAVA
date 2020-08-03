<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${loginInfo==null }">
		<script>
			alert('로그인에 실패하였습니다.');
			location.href=${referer};
		</script>

	</c:if>
	<c:if test="${loginInfo!=null}">
		<script>
			alert('로그인에 성공하였습니다.');
			location.href="<c:url value='/'/>";
		</script>
	</c:if>



</body>
</html>