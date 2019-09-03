<%@page import="com.mvc.bean.LeaveBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD EMPLOYEE</title>
<style>
#b1 {
	style: none;
	border: none;
	width: 180px;
	height: 20px;
	text-align: left;
}

div {
	text-align: center;
}
</style>
</head>
<body bgcolor="#EDBB99">
	<div>
		<table>
			<%
					String name = (String) session.getAttribute("name");
	String status = (String) session.getAttribute("status");
				%>
			<%=status %>
			<tr>
				<td>EmpName:</td>
				<td><button id="b1"><%=name%></button></td>
			</tr>
			<form action="LeaveManagementServlet?varname=applyempleave"
				method="POST">


				<tr>
					<td>StartDate:</td>
					<td><input type="text" name="StartDate" /><br> <br></td>
				</tr>
				<tr>
					<td>EndDate:</td>
					<td><input type="text" name="EndDate" /><br> <br></td>
				</tr>
				<tr>
					<td>Reason:</td>
					<td><input type="text" name="Reason" /><br> <br></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="submit" name="submit"></input><input
						type="reset" value="Reset"></input></td>
				</tr>
		</table>


		<br> <br> <a href=EmpServlet?varname=logout>LOGOUT</a><br>

		</form>

	</div>

</body>
</html>