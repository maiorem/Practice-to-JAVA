<%@page import="model.Emp"%>
<%@page import="java.util.List"%>
<%@page import="service.EmpListService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP LIST</title>
</head>
<body>

	<%
		List<Emp> empList=EmpListService.getInstance().getEmpList();
		request.setAttribute("empList", empList);
	%>
	
	<jsp:forward page="empList_view.jsp"/>
	
</body>
</html>