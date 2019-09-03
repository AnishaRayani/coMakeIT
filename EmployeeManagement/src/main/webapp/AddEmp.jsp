<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD EMPLOYEE</title>
<script>
	function validate() {
		var Empid = document.form.Empid.value;
		var EmpName = document.form.EmpName.value;
		var Email = document.form.Email.value;
		var DepartmentName = document.form.DepartmentName.value;
		var ReportingManager = document.form.ReportingManager.value;
		var Salary = document.form.Salary.value;
		if (Empid == null || Empid == "") {
			alert("Empid cannot be blank");
			return false;
		} else if (EmpName == null || EmpName == "") {
			alert("EmpName cannot be blank");
			return false;
		}
		else if (Email == null || Email == "") {
			alert("Email cannot be blank");
			return false;
		}
		else if (DepartmentName == null || DepartmentName == "") {
			alert("DepartmentName cannot be blank");
			return false;
		}
		else if (ReportingManager == null || ReportingManager == "") {
			alert("ReportingManager cannot be blank");
			return false;
		}
		else if (Salary == null || Salary == "") {
			alert("Salary cannot be blank");
			return false;
		}
	}
</script>
<style>
div {
	text-align: center;
}
</style>
</head>
<body bgcolor="#EDBB99">

	<br>
	<form name="form" action="EmpServlet?varname=addemployeedetails1"
		method="post" onsubmit="return validate()">

		<div>
			<table>

				<tr>
					<td>Empid:</td>
					<td><input type="text" name="Empid" /><br> <br></td>
				</tr>
				<tr>
					<td>EmpName:</td>
					<td><input type="text" name="EmpName" /><br> <br></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="Email" /><br> <br></td>
				</tr>
				<tr>
					<td>DepartmentName:</td>
					<td><input type="text" name="DepartmentName" /><br> <br></td>
				</tr>
				<tr>
					<td>ReportingManager:</td>
					<td><input type="text" name="ReportingManager" /><br> <br></td>
				</tr>
				<tr>
					<td>Salary:</td>
					<td><input type="text" name="Salary" /><br> <br></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="submit" name="submit"></input><input
						type="reset" value="Reset"></input></td>
				</tr>


			</table>


			<br> <br> <a href=EmpServlet?varname=adminoptions>GO
				BACK TO OPTIONS</a><br> <a href=EmpServlet?varname=logout>LOGOUT</a>
		</div>
	</form>

</body>
</html>