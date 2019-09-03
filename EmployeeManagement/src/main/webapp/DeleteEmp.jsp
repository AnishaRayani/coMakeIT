<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#FFA07A">
	<form action="DeleteEmpServlet?varname=deleteemployee1" method="POST">
		Empid:<input type="text" name="Empid"><br> <br> <input
			type="submit" value="submit" name="submit">
	</form>
	<br>
	<br>
	<a href=EmpServlet?varname=adminoptions>GO BACK TO OPTIONS</a>
	<br>
	<br>
	<a href=EmpServlet?varname=logout>LOGOUT</a>
	<br>
	<br>
</body>
</html>