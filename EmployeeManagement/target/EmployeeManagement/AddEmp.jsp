<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD EMPLOYEE</title>
<style>
div {text-align:center;}
</style>
</head>
<body bgcolor="#EDBB99">
<div>
<form action="EmpServlet?varname=addemployeedetails1" method="POST">

<table>

 <tr>
 <td>Empid:</td>
 <td><input type="text" name="Empid"/><br><br></td>
 </tr>
 <tr>
 <td>EmpName:</td>
 <td><input type="text" name="EmpName" /><br><br></td>
 </tr>
  <tr>
 <td>Email:</td>
 <td><input type="text" name="Email" /><br><br></td>
 </tr>
 <tr>
 <td>DepartmentName:</td>
 <td><input type="text" name="DepartmentName"/><br><br></td>
 </tr>
 <tr>
 <td>ReportingManager:</td>
 <td><input type="text" name="ReportingManager"/><br><br></td>
 </tr>
 <tr>
 <td>Salary:</td>
 <td><input type="text" name="Salary"/><br><br></td>
 </tr>
 <tr>
 <td></td>
 <td><input type="submit" value="submit" name="submit"></input><input
 type="reset" value="Reset"></input></td>
 </tr>
  
 
 </table>
	

<br><br><a href=EmpServlet?varname=employeeoptions>GO BACK TO OPTIONS</a><br>

	</form>
		
	</div>	
		
</body>
</html>