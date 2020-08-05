<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${deleteResult==1 }">
	<script>
		alert('회원 삭제가 완료되었습니다.');
	</script>
</c:if>
<c:if test="${deleteResult==0 }">
	<script>
		alert('회원 삭제에 실패하였습니다.');
	</script>
</c:if>