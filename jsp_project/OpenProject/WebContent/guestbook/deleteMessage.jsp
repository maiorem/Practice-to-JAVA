<%@page import="guestbook.service.DeleteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pw=request.getParameter("pw");
	int mid=Integer.parseInt(request.getParameter("mid"));
	
	DeleteMessageService service=DeleteMessageService.getInstance();
	int result=service.deleteMessage(mid, pw);
	
	request.setAttribute("resultCode", result);
	
%>
<jsp:forward page="deleteMessage_view.jsp"/>>