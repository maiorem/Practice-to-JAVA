<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	.check_ok {
		color : green;
	}
	.check_not {
		color : red;
	}
</style>
<link rel="stylesheet" href='<c:url value="/css/default.css"/>'>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div>
		
	<h1>회원가입</h1>
	<hr>
	<br>
    <form action="memberReg.do" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>아이디(이메일)</td>
                <td>
                <input type="email" name="uid" id="uid" placeholder="아이디(이메일)" required>
                <span id="checkmsg"></span>
                </td>
                
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="upw" placeholder="비밀번호" required></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="uname" placeholder="이름" required></td>
            </tr>
            <tr>
                <td>사진</td>
                <td><input type="file" name="uphoto"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="회원가입">
                    <input type="reset">
                </td>
            </tr>


        </table>
    </form>
	</div>
		
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
<script>

	$(document).ready(function(){
		$('#uid').focusout(function(){
			//비동기 통신
			$.ajax({
				url: 'idCheck.do',
				data: {	uid : $(this).val()},
				success: function(data){
					if(data=='Y') {
						$('#checkmsg').text("사용 가능한 아이디입니다.");
						$('#checkmsg').addClass('check_ok');
					} else {
						$('#checkmsg').text("사용 불가능한 아이디입니다.");
						$('#checkmsg').addClass('check_not');
					}
				} 
			});
			
		});	
	});

	</script>