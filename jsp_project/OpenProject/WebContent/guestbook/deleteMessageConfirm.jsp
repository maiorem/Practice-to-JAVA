<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function check() {
	if(confirm('정말로 삭제하시겠습니까?')){
		return true;
	};
	
	return false;
};

</script>

<link rel="stylesheet" href='<c:url value="/css/default.css"/>'>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<div>
		<h3>비밀번호를 입력해주세요.</h3>
		<form id="delForm" action="deleteMessage.jsp" method="post" onsubmit="return check();">
		비밀번호 <input type="password" name="pw">
		<input type="hidden" name="mid" value="${param.mid}">
		<input type="submit" value="삭제하기">
		</form>
	</div>
	<%@ include file="/include/footer.jsp" %>
</body>
</html>