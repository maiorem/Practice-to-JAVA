<%@page import="guestbook.service.WriteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="requsetMessage" class="guestbook.model.Message" scope="request"/>
<jsp:setProperty property="*" name="requsetMessage"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	WriteMessageService service=WriteMessageService.getInstance();
	int result=service.writeMessage(requsetMessage);
	
	request.setAttribute("writeMessage", result);
%>
<jsp:forward page="messageWrite_view.jsp"></jsp:forward>
</body>
</html>