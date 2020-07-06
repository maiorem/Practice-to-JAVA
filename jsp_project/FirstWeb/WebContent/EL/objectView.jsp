<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>교재 리스트 (배열)</h1>
	<ul>
		<li>${requestScope.bookNames[0]}</li>
		<li>${bookNames[1]}</li>
		<li>${bookNames[2]}</li>
	</ul>
	
	<h1>학습 순서 (List)</h1>
	<ol>
		<li>${study[0]}</li>
		<li>${study[1]}</li>
		<li>${study[2]}</li>
		<li>${study[3]}</li>		
	</ol>
	
	<h1>학생 정보 (Map)</h1>
	<ul>
		<li>${student.dept}</li>
		<li>${student.name}</li>
		<li>${student.phoneNumber }</li>
		
	</ul>
</body>
</html>