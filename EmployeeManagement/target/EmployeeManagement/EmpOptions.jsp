
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body bgcolor="#EDBB99">
<div style="text-align:center">
<%
	String name=(String)request.getAttribute("name");
	
	%>
	<a href=EmpServlet?varname=addemployeedetails>1).ADD EMPLOYEE</a><br><br>
	<a href=DeleteEmpServlet?varname=deleteemployee>2).DELETE EMPLOYEE</a><br><br>
	<a href=ListServlet?varname=listemployee>3).VIEW LIST OF EMPLOYEE</a><br><br>
	<a href=ListServlet?varname=listdepartment>4).VIEW LIST OF DEPARTMENT</a><br><br>
	<a href=ListServlet?varname=employeereporting>5).VIEW LIST OF EMPLOYEE REPORTING MANAGER</a><br><br>
	<a href=DetailsServlet?varname=employeedetails>6).VIEW EMPLOYEE DETAILS</a><br><br>
	<a href=DetailsServlet?varname=employeesalaryrange>7).VIEW LIST OF EMPLOYEE WHOSE SALARY RANGES FROM 10000 to 20000</a><br><br>
    <br><br><a href=EmpServlet?varname=logout>LOGOUT</a><br><br>
</div>
</body>
</html>