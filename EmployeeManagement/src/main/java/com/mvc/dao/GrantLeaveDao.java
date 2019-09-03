package com.mvc.dao;

import java.util.List;

import com.mvc.bean.LeaveBean;
import com.mvc.util.BusinessClass;

public class GrantLeaveDao {

	public List<LeaveBean> grant(String leaveid, String status, LeaveBean leavebean) {
		BusinessClass b = new BusinessClass();
		String result = b.grant(leaveid, status);
		if (result == "SUCCESS") {
			List<LeaveBean> object = b.leavelist(leavebean);
			return object;
		} else
			return null;
	}
}