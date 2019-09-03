package com.mvc.dao;

import com.mvc.bean.LeaveBean;
import com.mvc.util.BusinessClass;

public class EmpLeaveDao {
	public String empleave(LeaveBean leavebean) {
		BusinessClass b = new BusinessClass();
		String object = b.empleave(leavebean);
		return object;
	}
}
