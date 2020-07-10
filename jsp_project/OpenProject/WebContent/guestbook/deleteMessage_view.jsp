<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 메시지</title>
</head>
<body>
	<c:if test="${resultCode==1}">
		<script>
			alert('메시지가 정상적으로 삭제되었습니다.');
			
		</script>
	</c:if>
	<c:if test="${resultCode==-1}">
		<script>
			alert('삭제 할 메시지가 존재하지 않습니다.');
			
		</script>
	</c:if>
	<c:if test="${resultCode==-2}">
		<script>
			alert('비밀번호가 일치하지 않습니다.');			
		</script>
	</c:if>
	<a href="list.jsp">목록보기</a>
</body>
</html>