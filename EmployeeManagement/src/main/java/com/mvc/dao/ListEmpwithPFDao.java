package com.mvc.dao;

import java.util.List;
import com.mvc.bean.EmpBean;
import com.mvc.util.BusinessClass;

public class ListEmpwithPFDao {
	public List<EmpBean> listempwithpf() {
		BusinessClass b = new BusinessClass();
		List<EmpBean> object = b.listempwithpf();
		return object;
	}
}
