<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Admission Form</title>
</head>
<body>
<h2>${Title}</h2>
<h3>${student1.studentname}</h3>
<h2>${error}</h2>
<form action="/SpringDwp/submitAdmissionForm" method="post">
	<table>
	<tr>
		<td>Student Name: </td><td><input type = "text" name = "studentname" /></td>
	</tr>
	<tr>
		<td>Student Gender: </td>
		<td><input type = "radio" name = "studentgender" value ="Male"/>Male<br>
			<input type = "radio" name = "studentgender" value ="Female"/>Female
		</td>
	</tr>
	<tr>
		<td>Student Age: </td><td><input type = "text" name = "studentage" /></td>
	</tr>
	<tr>
		<td>Student Mobileno: </td><td><input type = "text" name = "studentmobile" /></td>
	</tr>
	<tr>
		<td>Student Date of Birth: </td><td><input type = "text" name = "studentdob" /></td>
	</tr>
	<tr>
		<td>Student Skills: </td><td><select name = "studentskills" multiple>
											<option value="Core Java">Core Java</option>
											<option value="Advance Java">Advance Java</option>
											<option value="Java Spring">Java Spring</option>
											<option value="Java Spring MVC">Java Spring MVC</option>
									</select>
								</td>
   </tr>
	<tr>
		<td><input type="submit" value = "Submit" /></td>
	</tr>
	</table>
</form>
</body>
</html>