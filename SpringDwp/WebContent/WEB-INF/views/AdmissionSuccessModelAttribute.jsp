<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${Title}</h2>
<h2>${msg}</h2>
<table>
	<tr>
		<td> Student Name : </td><td>${student1.studentname}</td>
	</tr>
	<tr>
		<td> Student Gender : </td><td>${student1.studentgender}</td>
	</tr>
	<tr>
		<td> Student Age : </td><td>${student1.studentage}</td>
	</tr>
	<tr>
		<td> Student Mobile : </td><td>${student1.studentmobile}</td>
	</tr>
	<tr>
		<td> Student DOB : </td><td>${student1.studentdob}</td>
	</tr>
	<tr>
		<td> Student Skills : </td><td>${student1.studentskills}</td>
	</tr>
</table>
</body>
</html>