package com.mvc.dao;

import com.mvc.bean.EmpBean;
import com.mvc.util.BusinessClass;

public class AddEmpDao {
	public String addUser(EmpBean empbean) {
		BusinessClass b = new BusinessClass();
		String object = b.add(empbean);
		return object;
	}
}
