package com.EmployeeManagement.EmployeeManagement;

import java.io.IOException;
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

import com.mvc.bean.AdminBean;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AdminBean adminbean = new AdminBean();
		adminbean.setusername(username);
		adminbean.setPassword(password);
		HttpSession session = request.getSession();
		session.setAttribute("name", adminbean.getusername());
		Client newClient = ClientBuilder.newClient(new ClientConfig());
		//Calls to MyResouce path validate For validation
		WebTarget web = newClient.target("http://localhost:8080/EmployeeManagement/webapi/myresource").path("validate");
		Invocation.Builder inBuilder = web.request(MediaType.APPLICATION_JSON);
		Response res = inBuilder.post(Entity.entity(adminbean, MediaType.APPLICATION_JSON));
		String restResponse = res.readEntity(String.class);
		if (restResponse.equals("ADMIN")) {
			response.sendRedirect("AdminOptions.jsp");
		} else if (restResponse.equals("EMPLOYEE")) {
			response.sendRedirect("EmployeeLeave.jsp");
		} else if (restResponse.equals("MANAGER")) {
			response.sendRedirect("ManagerLeave.jsp");
		} else {
			request.setAttribute("errMessage", "INVALID USERNAME OR PASSWORD");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
			System.out.println("Logged out");
		}
	}
}