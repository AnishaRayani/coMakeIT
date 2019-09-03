package com.EmployeeManagement.EmployeeManagement;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.mvc.bean.AdminBean;
import com.mvc.bean.EmpBean;
import com.mvc.bean.LeaveBean;
import com.mvc.dao.AddEmpDao;
import com.mvc.dao.DeleteEmpDao;
import com.mvc.dao.EmpLeaveDao;
import com.mvc.dao.GrantLeaveDao;
import com.mvc.dao.LeaveStatusDao;
import com.mvc.dao.ListDeptDao;
import com.mvc.dao.ListEmpDao;
import com.mvc.dao.ListEmpRangeDao;
import com.mvc.dao.ListEmpwithPFDao;
import com.mvc.dao.ListReportingManagerDao;
import com.mvc.dao.ManagerLeaveDao;
import com.mvc.dao.ValidationDao;

@Path("myresource")
public class MyResource {
    //LoginServlet calls for validation
	@POST
	@Path("validate")
	@Produces(MediaType.APPLICATION_JSON)
	public String getIt(String json) {
		AdminBean adminbean = new Gson().fromJson(json, AdminBean.class);
		ValidationDao validDao = new ValidationDao();
		String userValidate = validDao.authenticateUser(adminbean);
		return userValidate;
	}
	//EmpServlet calls for adding an employee
	@POST
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	public String add(EmpBean json) {
		AddEmpDao addempDao = new AddEmpDao();
		String userValidate = addempDao.addUser(json);
		return userValidate;
	}
	//DeleteEmpServlet calls for deleting an employee
	@DELETE
	@Path("delete/{id}")
	public String delete(@PathParam("id") String id) {
		DeleteEmpDao deleteempDao = new DeleteEmpDao();
		String userValidate = deleteempDao.deleteemp(id);
		return userValidate;
	}
	//ListServlet calls to display the list of employee orderby empid
	@GET
	@Path("listemp")
	@Produces(MediaType.APPLICATION_JSON)
	public String listemp() {
		ListEmpDao addempDao = new ListEmpDao();
		List<EmpBean> userValidate = addempDao.listemp();
		return new Gson().toJson(userValidate);
	}
	//ListServlet calls to display the list of employee orderby departmentname
	@GET
	@Path("listdept")
	@Produces(MediaType.APPLICATION_JSON)
	public String listdept() {
		ListDeptDao listdeptDao = new ListDeptDao();
		List<EmpBean> listdept = listdeptDao.listdept();
		return new Gson().toJson(listdept);
	}
	//ListServlet calls to display the list of employee under particular reportingmanager
	@GET
	@Path("listreportingmanager/{listreport}")
	@Produces(MediaType.APPLICATION_JSON)
	public String listreportingmanager(@PathParam("listreport") String listreport) {
		ListReportingManagerDao listreportDao = new ListReportingManagerDao();
		List<EmpBean> userValidate = listreportDao.listreport(listreport);
		return new Gson().toJson(userValidate);
	}
	//DetailsServlet calls to display the list of employee with pf
	@GET
	@Path("listempwithpf")
	@Produces(MediaType.APPLICATION_JSON)
	public String listempwithpf() {
		ListEmpwithPFDao addempDao = new ListEmpwithPFDao();
		List<EmpBean> userValidate = addempDao.listempwithpf();
		return new Gson().toJson(userValidate);
	}
	//DetailsServlet calls to display the list of employee under a particular range of salary
	@GET
	@Path("listrange")
	@Produces(MediaType.APPLICATION_JSON)
	public String listrange() {
		ListEmpRangeDao listdeptDao = new ListEmpRangeDao();
		List<EmpBean> listdept = listdeptDao.listrange();
		return new Gson().toJson(listdept);
	}
	//LeaveManagementServlet calls to apply a leave as employee and check status
	@POST
	@Path("empleave")
	@Produces(MediaType.APPLICATION_JSON)
	public String empleave(LeaveBean json) {
		EmpLeaveDao addempDao = new EmpLeaveDao();
		String userValidate = addempDao.empleave(json);
		return userValidate;
	}
	//LeaveManagementServlet calls to apply leave as manager and check status and grant leaves
	@POST
	@Path("managerleave")
	@Produces(MediaType.APPLICATION_JSON)
	public String managerleave(LeaveBean json) {
		ManagerLeaveDao addempDao = new ManagerLeaveDao();
		List<LeaveBean> userValidate = addempDao.managerleave(json);
		return new Gson().toJson(userValidate);
	}
	//GrantServlet calls to grant leave
	@POST
	@Path("grant/{leaveid}/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public String grant(@PathParam("leaveid") String leaveid, @PathParam("status") String status, LeaveBean json) {
		GrantLeaveDao grantleaveDao = new GrantLeaveDao();
		List<LeaveBean> userValidate = grantleaveDao.grant(leaveid, status, json);
		return new Gson().toJson(userValidate);
	}
	//LeaveManagementServlet calls to check the status of the leave
	@POST
	@Path("leavestatus")
	@Produces(MediaType.APPLICATION_JSON)
	public String leavestatus(LeaveBean json) {
		LeaveStatusDao leavestatusDao = new LeaveStatusDao();
		List<LeaveBean> userValidate = leavestatusDao.leavestatus(json);
		return new Gson().toJson(userValidate);
	}
}
