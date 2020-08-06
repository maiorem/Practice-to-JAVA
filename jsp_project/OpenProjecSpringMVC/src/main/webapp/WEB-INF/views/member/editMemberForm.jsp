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
	
	#idchk {
		display:none;
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
    <form id="editForm" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>아이디(이메일)</td>
                <td>
                <input type="email" name="editEmail" id="uid" value="${editId }" readonly>
                <span id="checkmsg"></span>
                <input type="checkbox" name="idchk" id="idchk">
                </td>
                
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="editPw" placeholder="비밀번호" required>
                <span id="checkpw"></span>
                </td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="editName" placeholder="이름" required>
                <span id="checkname"></span>
                </td>
            </tr>
            <tr>
                <td>사진</td>
                <td><input type="file" name="editPhoto"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="수정">
                    <input type="reset">
                </td>
            </tr>


        </table>
    </form>
	</div>
		
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
<!-- <script>

	$(document).ready(function(){
		
		$('#regForm').submit(function(){
			if(!$('#idchk').prop('checked')) {
				alert('아이디 중복 체크는 필수 항목 입니다.');
				$('#uid').focus();
				return false;
			}			
		
		});
		
		
		$('#uid').focusin(function(){
			
			$(this).val('');
			$('#idchk').prop('checked', false);
			
			$('#checkmsg').text('');
			
			$('#checkmsg').removeClass('check_not');
			$('#checkmsg').removeClass('check_ok');
		});
		
		$('#uid').focusout(function(){
			
			if($(this).val().length<1) {
				$('#checkmsg').text("아이디는 필수 항목입니다.");
				$('#checkmsg').addClass('check_not');
				return false;
			}
			
			
			//비동기 통신
			$.ajax({
				url: 'idCheck.do',
				data: {	uid : $(this).val()},
				success: function(data){
					if(data=='Y') {
						$('#checkmsg').text("사용 가능한 아이디입니다.");
						$('#checkmsg').addClass('check_ok');
						$('#idchk').prop('checked', true);
					} else {
						$('#checkmsg').text("사용 불가능한 아이디입니다.");
						$('#checkmsg').addClass('check_not');
						$('#idchk').prop('checked', false);
					}
				} 
			});
			
		});	
		

	});

</script> -->