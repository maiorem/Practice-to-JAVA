<%@page import="member.service.MemberRegService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberRegService service=MemberRegService.getInstance();
	int result=service.regPhoto(request);
	request.setAttribute("memberResult", result);
%>
<jsp:forward page="reg_view.jsp"></jsp:forward>
</body>
</html>