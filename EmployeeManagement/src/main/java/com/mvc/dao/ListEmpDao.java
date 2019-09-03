package com.mvc.dao;

import java.util.List;
import com.mvc.bean.EmpBean;
import com.mvc.util.BusinessClass;

public class ListEmpDao {
	public List<EmpBean> listemp() {
		BusinessClass b = new BusinessClass();
		List<EmpBean> object = b.listofempbyid();
		return object;
	}
}
