<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#EDBB99">
	<form action="ListServlet?varname=employeereporting1" method="POST">
		REPORTING MANAGER:<input type="text" name="ReportingManager"><br>
		<br> <input type="submit" value="submit" name="submit">
	</form>
	<br>
	<br>
	<a href=EmpServlet?varname=adminoptions>GO BACK TO OPTIONS</a>
	<a href=EmpServlet?varname=logout>LOGOUT</a>
	<br>
	<br>
</body>
</html>