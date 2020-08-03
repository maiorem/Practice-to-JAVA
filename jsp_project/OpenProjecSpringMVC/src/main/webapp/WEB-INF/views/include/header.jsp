<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 id="header">Open Project</h1>
<ul id="nav">
	<c:if test="${loginMember==null }">
		<li><a href="<c:url value='/member/reg' />">회원가입</a></li>
		<li><a href='<c:url value="/member/login"/>'>로그인</a></li>
	</c:if>
	<c:if test="${loginMember!=null }">
		<li><a href='<c:url value="/member/logout"/>'>로그아웃</a></li>
		<li><a href='<c:url value="/member/mypage/mypage"/>'>마이페이지</a></li>
	</c:if>
	<li><a href='<c:url value="/guestbook/list"/>'>방명록(비회원)</a></li>
	<li><a href='<c:url value="/board/list"/>'>게시판(회원제)</a></li>
</ul>




