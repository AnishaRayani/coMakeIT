package com.EmployeeManagement.EmployeeManagement;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mvc.bean.LeaveBean;

public class LeaveManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LeaveManagementServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String function = request.getParameter("varname");
		if (function.equals("empleave")) {

			HttpSession session = request.getSession(false);
			String empbean = (String) session.getAttribute("name");
			RequestDispatcher r = request.getRequestDispatcher("ApplyEmpLeave.jsp");
			request.setAttribute("name", empbean);
			r.forward(request, response);
		} else if (function.equals("applyempleave")) {
			LeaveBean leavebean = new LeaveBean();
			HttpSession session = request.getSession(false);
			leavebean.setEmpname((String) session.getAttribute("name"));
			leavebean.setStartdate((String) request.getParameter("StartDate"));
			leavebean.setEnddate((String) request.getParameter("EndDate"));
			leavebean.setReason((String) request.getParameter("Reason"));
			Client newClient = ClientBuilder.newClient(new ClientConfig());
			//Calls to MyResouce path empleave for applying a leave as employee and check status
			WebTarget web = newClient.target("http://localhost:8080/EmployeeManagement/webapi/myresource")
					.path("empleave");
			Invocation.Builder inBuilder = web.request(MediaType.APPLICATION_JSON);
			Response res = inBuilder.post(Entity.entity(leavebean, MediaType.APPLICATION_JSON));
			String restResponse = res.readEntity(String.class);
			if (restResponse.contentEquals("SUCCESS"))
				response.sendRedirect("LeaveAppliedSuccess.jsp");
			else
				response.sendRedirect("LeaveAppliedError.jsp");

		} else if (function.equals("viewleave")) {
			LeaveBean leavebean = new LeaveBean();
			HttpSession session = request.getSession(false);
			leavebean.setEmpname((String) session.getAttribute("name"));
			Client newClient = ClientBuilder.newClient(new ClientConfig());
			//Calls to MyResouce path managerleave for applying a leave as manager and check status and grant leaves
			WebTarget web = newClient.target("http://localhost:8080/EmployeeManagement/webapi/myresource")
					.path("managerleave");
			Invocation.Builder inBuilder = web.request(MediaType.APPLICATION_JSON);
			Response res = inBuilder.post(Entity.entity(leavebean, MediaType.APPLICATION_JSON));
			String restResponse = res.readEntity(String.class);
			Type type = new TypeToken<List<LeaveBean>>() {
			}.getType();
			List<LeaveBean> listPersons = new Gson().fromJson(restResponse, type);
			RequestDispatcher r = request.getRequestDispatcher("ViewLeave.jsp");
			request.setAttribute("list", listPersons);
			r.forward(request, response);

		} else if (function.equals("leavestatus")) {
			LeaveBean leavebean = new LeaveBean();
			HttpSession session = request.getSession(false);
			leavebean.setEmpname((String) session.getAttribute("name"));
			Client newClient = ClientBuilder.newClient(new ClientConfig());
			//Calls to MyResouce path leavestatus to check the status of the leave
			WebTarget web = newClient.target("http://localhost:8080/EmployeeManagement/webapi/myresource")
					.path("leavestatus");
			Invocation.Builder inBuilder = web.request(MediaType.APPLICATION_JSON);
			Response res = inBuilder.post(Entity.entity(leavebean, MediaType.APPLICATION_JSON));
			String restResponse = res.readEntity(String.class);
			Type type = new TypeToken<List<LeaveBean>>() {
			}.getType();
			List<LeaveBean> listPersons = new Gson().fromJson(restResponse, type);
			RequestDispatcher r = request.getRequestDispatcher("CheckStatus.jsp");
			request.setAttribute("list", listPersons);
			r.forward(request, response);

		}

	}
}
