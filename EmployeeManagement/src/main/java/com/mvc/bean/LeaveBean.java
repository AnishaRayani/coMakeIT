package com.mvc.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LeaveBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int leaveid;
	private String empname;
	private String startdate;
	private String enddate;
	private String reason;
	private String status;

	static List<LeaveBean> list;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getLeaveid() {
		return leaveid;
	}

	public void setLeaveid(int leaveid) {
		this.leaveid = leaveid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setList(List<LeaveBean> listPersons) {
		LeaveBean.list = listPersons;
	}

	public List<LeaveBean> getList() {
		return LeaveBean.list;

	}
}
