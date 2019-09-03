<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
  <%@page import="java.sql.DriverManager,com.mvc.bean.EmpBean"%>
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
<div style="text-align:center">
 
<table  border="10" style="width:100%"> 
<tr><th>Employee ID</th><th>Employee Name</th><th>Email</th><th>Department Name</th><th>Reporting Manager</th><th>Salary</th><th>PF</th></tr>
<%

List<EmpBean> list = (List<EmpBean>) request.getAttribute("list");
%>
<%
for (EmpBean b: list)
{
%>
<tr> 
	<td><%=b.getEmpid()%></td> 
	<td><%=b.getEmpName()%></td> 
	<td><%=b.getEmail()%></td> 
	<td><%=b.getDepartmentName()%></td> 
	<td><%=b.getReportingManager()%></td> 
	<td><%=b.getSalary()%></td>
	<td><%=b.getPF()%></td>
	
	 
	</tr> 
	<%} %>


</table>
<br><br><a href=EmpServlet?varname=employeeoptions>GO BACK TO OPTIONS</a><br><br>
</div>
</body>

</html>