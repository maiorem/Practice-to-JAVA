<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 페이지</title>
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
		
	<h1>회원 정보 수정</h1>
	<hr>
	<br>
    <form id="regForm" action="editMember.do" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>아이디(이메일)</td>
                <td>
                <input type="email" name="uid" id="uid" value="${editMember.uid}" readonly> 아이디는 수정할 수 없습니다.
                </td>
                
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>
                <input type="password" name="upw" id="upw" placeholder="비밀번호" required>
                <span id="checkmsg"></span>
                </td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="uname" id="uname" placeholder="이름" required></td>
            </tr>
            <tr>
                <td>사진</td>
                <td><input type="file" name="uphoto"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="정보 수정">
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
		
		
		$('#upw').focusin(function(){			
			$(this).val('');
			$('#checkmsg').text('');
			$('#checkmsg').removeClass('check_not');
			$('#checkmsg').removeClass('check_ok');
		});
		
		$('#upw').focusout(function(){
			
			if($(this).val().length<1) {
				$('#checkmsg').text("비밀번호는 필수 항목입니다.");
				$('#checkmsg').addClass('check_not');
				return false;
			}
			
		});	
		
		$('#uname').focusin(function(){			
			$(this).val('');
			$('#checkmsg').text('');
			$('#checkmsg').removeClass('check_not');
			$('#checkmsg').removeClass('check_ok');
		});
		
		$('#uname').focusout(function(){
			
			if($(this).val().length<1) {
				$('#checkmsg').text("회원 이름은 필수 항목입니다.");
				$('#checkmsg').addClass('check_not');
				return false;
			}
			
		});	
		
	});

	</script>