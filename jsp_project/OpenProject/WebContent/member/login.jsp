<%@page import="java.util.HashMap"%>
<%@page import="model.MemberInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<%	String uid=request.getParameter("id");
	String upw=request.getParameter("pw");
	String ucheck=request.getParameter("check");
	
	HashMap<String, MemberInfo> info= (HashMap<String, MemberInfo>) application.getAttribute(uid);
	
	String username=info.get(uid).getUsername();
	String userphoto=info.get(uid).getUserphoto();
	
	String cookieName="id";
	String cookiePath=request.getContextPath();
	
	boolean loginCheck=false;
	
	if(uid.equals(info.get(uid).getUid()) && upw.equals(info.get(uid).getUpw())) {
		session.setAttribute("member", new MemberInfo(uid, upw, username, userphoto));
		loginCheck=true;
	}
%>
<%
	if(loginCheck) {	
		if(ucheck!=null) {
			response.addCookie(CookieBox.createCookie(cookieName, uid, cookiePath, 60*60*24*365)); //쿠키 생성
		} else {
			response.addCookie(CookieBox.createCookie(cookieName, uid, cookiePath, 0));	//쿠키 삭제
		}
		
		response.sendRedirect("<c:url value='/member/mypage/mypage.jsp'>");

	} else {
		
%>
<script>
	alert("아이디 또는 비밀번호를 확인해주세요.");
	history.go(-1);
</script>

<% 
	}
%>