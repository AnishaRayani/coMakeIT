package com.mvc.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmpBean {
	@Id
	private String empid;
	private String empname;
	private String email;
	private String departmentname;
	private String reportingmanager;
	private float salary;

	static List<EmpBean> list;

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getReportingmanager() {
		return reportingmanager;
	}

	public void setReportingmanager(String reportingmanager) {
		this.reportingmanager = reportingmanager;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public void setList(List<EmpBean> listPersons) {
		EmpBean.list = listPersons;
	}

	public List<EmpBean> getList() {
		return EmpBean.list;

	}
}