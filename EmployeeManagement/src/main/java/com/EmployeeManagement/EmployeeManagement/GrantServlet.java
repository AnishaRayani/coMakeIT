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

public class GrantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GrantServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LeaveBean leavebean = new LeaveBean();
		HttpSession session = request.getSession(false);
		leavebean.setEmpname((String) session.getAttribute("name"));
		int leaveid = Integer.parseInt(request.getParameter("leaveid"));
		String status = request.getParameter("status");
		leavebean.setLeaveid(leaveid);
		leavebean.setStatus(status);
		Client newClient = ClientBuilder.newClient(new ClientConfig());
		//Calls to MyResouce path grant/{leaveid}/{status} to grant leave
		WebTarget web = newClient.target("http://localhost:8080/EmployeeManagement/webapi/myresource/grant/"
				+ leavebean.getLeaveid() + "/" + leavebean.getStatus());
		Invocation.Builder inBuilder = web.request(MediaType.APPLICATION_JSON);
		Response res = inBuilder.post(Entity.entity(leavebean, MediaType.APPLICATION_JSON));
		String restResponse = res.readEntity(String.class);
		Type type = new TypeToken<List<LeaveBean>>() {
		}.getType();
		List<LeaveBean> listPersons = new Gson().fromJson(restResponse, type);
		RequestDispatcher r = request.getRequestDispatcher("ViewLeave.jsp");
		request.setAttribute("list", listPersons);
		r.forward(request, response);

	}

}
