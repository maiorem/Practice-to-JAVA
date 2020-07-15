<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 id="header">Open Project</h1>
<ul id="nav">
	<li><a href='<c:url value="/member/memberRegForm.do"/>'>회원가입</a></li>
	<c:if test="${loginMember==null }">
	<li><a href='<c:url value="/member/memberloginForm.do"/>'>로그인</a></li>
	</c:if>
	<c:if test="${loginMember!=null }">
	<li><a href='<c:url value="/member/memberlogout.do"/>'>로그아웃</a></li>
	</c:if>
	<li><a href='<c:url value="/member/mypage/mypage.do"/>'>마이페이지</a></li>
	<li><a href='<c:url value="/guestbook/list.do"/>'>방명록(비회원)</a></li>
	<li><a href='<c:url value="/board/list.do"/>'>게시판(회원제)</a></li>
	<li><a href='<c:url value="/member/memberList.do"/>'>회원 관리</a></li>
</ul>




