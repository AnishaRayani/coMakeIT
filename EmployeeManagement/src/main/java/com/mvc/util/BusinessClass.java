package com.mvc.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.mvc.bean.AdminBean;
import com.mvc.bean.EmpBean;
import com.mvc.bean.LeaveBean;

public class BusinessClass {
	private EntityManager entityManager = null;

	public String get(AdminBean adminbean) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeManagement");
		entityManager = entityManagerFactory.createEntityManager();
		AdminBean a = entityManager.find(AdminBean.class, adminbean.getusername());
		if (adminbean.getusername().equals(a.getusername())) {
			if (adminbean.getPassword().equals(a.getPassword())) {
				if (a.getRole().equals("admin")) {
					return "ADMIN";
				} else {
					entityManager.getTransaction().begin();
					String queryString = "SELECT empname FROM EmpBean where reportingmanager='" + a.getusername() + "'";
					Query query = entityManager.createQuery(queryString);
					@SuppressWarnings("unchecked")
					ArrayList<String> resultList = (ArrayList<String>) query.getResultList();
					entityManager.getTransaction().commit();
					entityManager.close();
					entityManagerFactory.close();
					if (resultList.size() > 0)
						return "MANAGER";
					else
						return "EMPLOYEE";
				}
			}
		}
		return "ERROR";
	}

	public String add(EmpBean empbean) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeManagement");
		entityManager = entityManagerFactory.createEntityManager();
		String Email = empbean.getEmail();
		Pattern pattern;
		Matcher matcher;
		pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@+[A-Za-z0-9-]+(\\.[A-Za-z]{2,3})?(\\.[A-Za-z]{2,3})$");
		matcher = pattern.matcher(Email);
		EmpBean empbean1 = entityManager.find(EmpBean.class, empbean.getEmpid());
		if (empbean1 != null) {
			return "ERROR";
		}
		if (matcher.matches()) {
			AdminBean adminbean = new AdminBean();
			adminbean.setusername(empbean.getEmpname());
			adminbean.setPassword(empbean.getEmpname() + "123");
			adminbean.setRole("user");
			entityManager.getTransaction().begin();
			entityManager.persist(adminbean);
			entityManager.persist(empbean);
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
			return "SUCCESS";
		}
		return "ERROR";
	}

	public String delete(String id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeManagement");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		EmpBean a = entityManager.find(EmpBean.class, id);
		AdminBean admin = entityManager.find(AdminBean.class, a.getEmpname());
		entityManager.remove(a);
		entityManager.remove(admin);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return "SUCCESS";
	}

	public List<EmpBean> listofempbyid() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeManagement");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<EmpBean> listPersons = entityManager.createQuery("SELECT x FROM EmpBean x ORDER BY x.empid", EmpBean.class)
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return listPersons;
	}

	public List<EmpBean> listdept() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeManagement");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<EmpBean> listPersons = entityManager
				.createQuery("SELECT x FROM EmpBean x ORDER BY x.departmentname", EmpBean.class).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return listPersons;
	}

	public List<EmpBean> listreport(String listreport) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeManagement");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<EmpBean> listPersons = entityManager
				.createQuery("select x FROM EmpBean x WHERE x.reportingmanager = '" + listreport + "'", EmpBean.class)
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return (List<EmpBean>) listPersons;
	}

	public List<EmpBean> listempwithpf() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeManagement");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<EmpBean> listPersons = entityManager
				.createNativeQuery("SELECT Empid,EmpName,Email,DepartmentName,ReportingManager,Salary FROM EmpBean",
						EmpBean.class)
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return listPersons;
	}

	public List<EmpBean> listrange() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeManagement");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<EmpBean> listPersons = entityManager
				.createNativeQuery(" select * from EmpBean where Salary between 10000 and 20000", EmpBean.class)
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return listPersons;
	}

	public String empleave(LeaveBean leavebean) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeManagement");
		entityManager = entityManagerFactory.createEntityManager();
		leavebean.setStatus("Pending");
		if (entityManager != null) {
			entityManager.getTransaction().begin();
			entityManager.persist(leavebean);
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
			return "SUCCESS";
		}
		return "ERROR";
	}

	public List<LeaveBean> leavelist(LeaveBean leavebean) {
		String name = leavebean.getEmpname();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeManagement");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<EmpBean> listmanager = entityManager
				.createQuery("SELECT x FROM EmpBean x WHERE x.reportingmanager = '" + name + "'", EmpBean.class)
				.getResultList();
		List<String> empnames = new ArrayList<>();
		for (EmpBean x : listmanager) {
			empnames.add(x.getEmpname());
		}
		List<LeaveBean> listPersons = entityManager
				.createQuery("SELECT x FROM LeaveBean x WHERE x.empname in :names", LeaveBean.class)
				.setParameter("names", empnames).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return listPersons;
	}

	public String grant(String leaveid, String status) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeManagement");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		@SuppressWarnings("unused")
		int query = entityManager
				.createNativeQuery("UPDATE LeaveBean SET status='" + status + "' WHERE leaveid = '" + leaveid + "'",
						LeaveBean.class)
				.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return "SUCCESS";
	}

	public List<LeaveBean> leavestatus(LeaveBean leavebean) {
		String name = leavebean.getEmpname();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeManagement");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<LeaveBean> listPersons = entityManager
				.createQuery("SELECT x FROM LeaveBean x WHERE x.empname ='" + name + "'", LeaveBean.class)
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return listPersons;
	}
}
