package com.EmployeeManagement.EmployeeManagement;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mvc.bean.EmpBean;

public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetailsServlet() {
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
		if (function.equals("employeedetails")) {
			Client newClient = ClientBuilder.newClient(new ClientConfig());
			//Calls to MyResouce path listempwithpf for displaying the list of employee with pf
			WebTarget web = newClient.target("http://localhost:8080/EmployeeManagement/webapi/myresource")
					.path("listempwithpf");
			Invocation.Builder inBuilder = web.request(MediaType.APPLICATION_JSON);
			Response res = inBuilder.get();
			String restResponse = res.readEntity(String.class);
			Type type = new TypeToken<List<EmpBean>>() {
			}.getType();
			List<EmpBean> listPersons = new Gson().fromJson(restResponse, type);
			request.setAttribute("list", listPersons);
			request.getRequestDispatcher("EmpDetails.jsp").forward(request, response);
		} else if (function.equals("employeesalaryrange")) {
			Client newClient = ClientBuilder.newClient(new ClientConfig());
			//Calls to MyResouce path listrange for displaying the list of employee within a particular range of salary
			WebTarget web = newClient.target("http://localhost:8080/EmployeeManagement/webapi/myresource")
					.path("listrange");
			Invocation.Builder inBuilder = web.request(MediaType.APPLICATION_JSON);
			Response res = inBuilder.get();
			String restResponse = res.readEntity(String.class);
			Type type = new TypeToken<List<EmpBean>>() {
			}.getType();
			List<EmpBean> listPersons = new Gson().fromJson(restResponse, type);
			request.setAttribute("list", listPersons);
			request.getRequestDispatcher("Display.jsp").forward(request, response);
		}
	}
}
