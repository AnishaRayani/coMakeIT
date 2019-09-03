package com.mvc.dao;

import com.mvc.bean.AdminBean;
import com.mvc.util.BusinessClass;

public class ValidationDao {
	public String authenticateUser(AdminBean adminbean) {
		BusinessClass b = new BusinessClass();
		String object = b.get(adminbean);
		return object;

	}
}