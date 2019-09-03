package com.mvc.dao;

import java.util.List;
import com.mvc.bean.LeaveBean;
import com.mvc.util.BusinessClass;

public class ManagerLeaveDao {
	public List<LeaveBean> managerleave(LeaveBean leavebean) {
		BusinessClass b = new BusinessClass();
		List<LeaveBean> object = b.leavelist(leavebean);
		return object;
	}
}
