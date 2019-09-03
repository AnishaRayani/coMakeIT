
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body bgcolor="#EDBB99">
	<div style="text-align: center">
		<h3>WELCOME EMPLOYEE</h3>
		<%
			String name = (String) request.getAttribute("name");
		%>
		<a href=LeaveManagementServlet?varname=empleave>1).APPLY FOR LEAVE</a><br>
		<br> <a href=LeaveManagementServlet?varname=viewleave>2).GRANT
			PERMISSION FOR LEAVE</a><br> <br> <a
			href=LeaveManagementServlet?varname=leavestatus>3).CHECK STATUS
			FOR LEAVE</a><br> <br> <br> <br> <br> <br>
		<br> <a href=EmpServlet?varname=logout>LOGOUT</a><br> <br>
	</div>
</body>
</html>