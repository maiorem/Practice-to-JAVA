<%@page import="model.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	MemberInfo memberInfo = (MemberInfo) session.getAttribute("member");
%>

<h1 id="header">Open Project</h1>
<ul id="nav">
	<li><a href='<c:url value="/member/memberRegForm.jsp"/>'>회원가입</a></li>
	<% 
	if(memberInfo==null) {
	%>
	<li><a href='<c:url value="/member/loginForm.jsp"/>'>로그인</a></li>
	<%
	} else {
	%>
	<li><a href='<c:url value="/member/logout.jsp"/>'>로그아웃</a></li>
	<% 
	}
	%>
	<li><a href='<c:url value="/member/mypage/mypage.jsp"/>'>마이페이지</a></li>
	<li><a href='<c:url value="/guestbook/list.jsp"/>'>방명록(비회원)</a></li>
	<li><a href='<c:url value="/board/list.jsp"/>'>게시판(회원제)</a></li>
</ul>




