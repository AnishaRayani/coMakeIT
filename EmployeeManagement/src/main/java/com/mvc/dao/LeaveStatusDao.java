package com.mvc.dao;

import java.util.List;

import com.mvc.bean.LeaveBean;
import com.mvc.util.BusinessClass;

public class LeaveStatusDao {

	public List<LeaveBean> leavestatus(LeaveBean leavebean) {
		BusinessClass b = new BusinessClass();
		List<LeaveBean> object = b.leavestatus(leavebean);
		return object;
	}
}
