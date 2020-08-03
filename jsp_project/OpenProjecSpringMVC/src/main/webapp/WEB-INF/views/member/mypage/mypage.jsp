<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href='<c:url value="/css/default.css"/>'>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div>

		아이디 : ${loginMember.email } <br> 이름 : ${loginMember.name } <br>
		가입 날짜 : ${loginMember.regdate} <br> 프로필 사진 : <img
			src="${loginMember.photoPath}" style="width: 100px;"> <br>
		<button>
			<a href="#">회원 정보 수정</a>
		</button>
		<br>
		<button>
			<a href="#">회원 탈퇴</a>
		</button>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>