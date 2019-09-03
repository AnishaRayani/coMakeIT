package com.EmployeeManagement.EmployeeManagement;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListServlet() {
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
		if (function.equals("listemployee")) {
			Client newClient = ClientBuilder.newClient(new ClientConfig());
			//Calls to MyResouce path listemp for displaying the list of employee order by empid
			WebTarget web = newClient.target("http://localhost:8080/EmployeeManagement/webapi/myresource")
					.path("listemp");
			Invocation.Builder inBuilder = web.request(MediaType.APPLICATION_JSON);
			Response res = inBuilder.get();
			String restResponse = res.readEntity(String.class);
			Type type = new TypeToken<List<EmpBean>>() {
			}.getType();
			List<EmpBean> listPersons = new Gson().fromJson(restResponse, type);
			RequestDispatcher r = request.getRequestDispatcher("Display.jsp");
			request.setAttribute("list", listPersons);
			r.forward(request, response);
		} else if (function.equals("listdepartment")) {
			Client newClient = ClientBuilder.newClient(new ClientConfig());
			//Calls to MyResouce path listdept for displaying the list of employee order by departmentname
			WebTarget web = newClient.target("http://localhost:8080/EmployeeManagement/webapi/myresource")
					.path("listdept");
			Invocation.Builder inBuilder = web.request(MediaType.APPLICATION_JSON);
			Response res = inBuilder.get();
			String restResponse = res.readEntity(String.class);
			Type type = new TypeToken<List<EmpBean>>() {
			}.getType();
			List<EmpBean> listPersons = new Gson().fromJson(restResponse, type);
			RequestDispatcher r = request.getRequestDispatcher("Display.jsp");
			request.setAttribute("list", listPersons);
			r.forward(request, response);
		} else if (function.equals("employeereporting")) {
			response.sendRedirect("EmpReport.jsp");
		} else if (function.equals("employeereporting1")) {
			EmpBean empbean = new EmpBean();
			empbean.setReportingmanager((String) request.getParameter("ReportingManager"));
			Client newClient = ClientBuilder.newClient(new ClientConfig());
			//Calls to MyResouce path listreportingmanager/{listreport} for displaying the list of employee under particular reportingmanager
			WebTarget web = newClient
					.target("http://localhost:8080/EmployeeManagement/webapi/myresource/listreportingmanager/"
							+ empbean.getReportingmanager());
			Invocation.Builder inBuilder = web.request(MediaType.APPLICATION_JSON);
			Response res = inBuilder.get();
			String restResponse = res.readEntity(String.class);
			Type type = new TypeToken<List<EmpBean>>() {
			}.getType();
			List<EmpBean> listPersons = new Gson().fromJson(restResponse, type);
			RequestDispatcher r = request.getRequestDispatcher("Display.jsp");
			request.setAttribute("list", listPersons);
			r.forward(request, response);
		}
	}
}
