<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	아이디 : ${loginMember.id }
	이름 : ${loginMember.name }
	프로필 사진 : <img src="${loginMember.photoPath}" style="width : 100px;">
	
	<button><a href="#">회원 정보 수정</a></button>
	<button><a href="#">회원 탈퇴</a></button>
	
</body>
</html>