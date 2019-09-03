package com.EmployeeManagement.EmployeeManagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.mvc.bean.EmpBean;

public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteEmpServlet() {
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
		if (function.equals("deleteemployee")) {
			response.sendRedirect("DeleteEmp.jsp");
		} else if (function.equals("deleteemployee1")) {
			EmpBean empbean = new EmpBean();
			empbean.setEmpid((String) request.getParameter("Empid"));
			Client newClient = ClientBuilder.newClient(new ClientConfig());
			//Calls to MyResouce path delete/{id} for deleting an employee
			WebTarget web = newClient
					.target("http://localhost:8080/EmployeeManagement/webapi/myresource/delete/" + empbean.getEmpid());
			Invocation.Builder inBuilder = web.request(MediaType.APPLICATION_JSON);
			Response res = inBuilder.delete();
			String restResponse = res.readEntity(String.class);
			if (restResponse.contentEquals("SUCCESS"))
				response.sendRedirect("DeleteEmpsuccess.jsp");
			else
				response.sendRedirect("DeleteEmpError.jsp");
		}
	}
}
