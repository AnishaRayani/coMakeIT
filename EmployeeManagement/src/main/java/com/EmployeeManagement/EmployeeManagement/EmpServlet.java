package com.EmployeeManagement.EmployeeManagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.mvc.bean.EmpBean;

public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String function = request.getParameter("varname");
		PrintWriter out = response.getWriter();
		if (function.equals("addemployeedetails")) {
			response.sendRedirect("AddEmp.jsp");
		} else if (function.equals("addemployeedetails1")) {
			EmpBean empbean = new EmpBean();
			empbean.setEmpid((String) request.getParameter("Empid"));
			empbean.setEmpname((String) request.getParameter("EmpName"));
			empbean.setEmail((String) request.getParameter("Email"));
			empbean.setDepartmentname((String) request.getParameter("DepartmentName"));
			empbean.setReportingmanager((String) request.getParameter("ReportingManager"));
			String Salary = request.getParameter("Salary");
			int salary = Integer.parseInt(Salary);
			empbean.setSalary(salary);
			Client newClient = ClientBuilder.newClient(new ClientConfig());
			//Calls to MyResouce path add for adding an employee
			WebTarget web = newClient.target("http://localhost:8080/EmployeeManagement/webapi/myresource").path("add");
			Invocation.Builder inBuilder = web.request(MediaType.APPLICATION_JSON);
			Response res = inBuilder.post(Entity.entity(empbean, MediaType.APPLICATION_JSON));
			String restResponse = res.readEntity(String.class);
			out.println(restResponse);
			if (restResponse.contentEquals("SUCCESS"))
				response.sendRedirect("AddEmpSuccess.jsp");
			else
				response.sendRedirect("AddEmperror.jsp");

		} else if (function.equals("adminoptions")) {
			response.sendRedirect("AdminOptions.jsp");

		} else if (function.contentEquals("logout")) {

			request.setAttribute("errMessage", "You have logged out successfully");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
			System.out.println("Logged out");

		}
	}

}
