<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${editResult==1 }">
	<script>
		alert('회원 정보 수정이 완료되었습니다.');
	</script>
</c:if>
<c:if test="${editResult==0 }">
	<script>
		alert('회원 정보 수정에 실패하였습니다.');
	</script>
</c:if>