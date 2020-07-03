<%@page import="model.MemberInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	MemberInfo info= (MemberInfo) application.getAttribute("info");

	String uid=request.getParameter("id");
	String upw=request.getParameter("pw");
	String ucheck=request.getParameter("check");
	
	String cookieName="id";
	String cookiePath=request.getContextPath();
	
	boolean loginCheck=false;
	


	
	if(uid.equals(info.getUid()) && upw.equals(info.getUpw())) {
		session.setAttribute("member", new MemberInfo(uid, upw));
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
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/default.css">
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
</head>

<body>
	<%@ include file="/include/header.jsp"%>
	<div>
		<h1>로그인 완료</h1>
		id : <%=uid %>
		<br>
		pw : <%=upw %>
		<br>
		<%
			if(ucheck!=null) {
				out.println("아이디를 저장합니다.");
			} else {
				out.println("아이디를 저장하지 않습니다.");
			}
		%>

	</div>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>
<%
	} else {
		
%>
<script>
	alert("아이디 또는 비밀번호를 확인해주세요.");
	history.go(-1);
</script>

<% 
	}
%>