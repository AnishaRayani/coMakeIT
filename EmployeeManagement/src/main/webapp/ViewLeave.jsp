<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="java.sql.DriverManager,com.mvc.bean.LeaveBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body bgcolor="#EDBB99">
	<div style="text-align: center">

		<table border="10" style="width: 80%">
			<tr>
				<th>LEAVE ID</th>
				<th>Employee Name</th>
				<th>STARTDATE</th>
				<th>ENDDATE</th>
				<th>REASON</th>
				<th>STATUS</th>
				<th>ACCEPT</th>
				<th>REJECT</th>
			</tr>
			<%
				List<LeaveBean> list = (List<LeaveBean>) request.getAttribute("list");
			%>
			<%
				for (LeaveBean b : list) {
			%>
			<tr>
				<td><%=b.getLeaveid()%></td>
				<td><%=b.getEmpname()%></td>
				<td><%=b.getStartdate()%></td>
				<td><%=b.getEnddate()%></td>
				<td><%=b.getReason()%></td>
				<td><%=b.getStatus()%></td>
				<td><a href=GrantServlet?leaveid=
					<%out.print(b.getLeaveid());%>&status=accept>>accept</a></td>
				<td><a href=GrantServlet?leaveid=
					<%out.print(b.getLeaveid());%>&status=reject>>reject</a></td>
			</tr>
			<%
				}
			%>


		</table>
		<br> <br> <a href=EmpServlet?varname=logout>LOGOUT</a> <br>
	</div>
</body>

</html>