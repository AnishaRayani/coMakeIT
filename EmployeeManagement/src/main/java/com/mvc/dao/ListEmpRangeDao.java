package com.mvc.dao;

import java.util.List;
import com.mvc.bean.EmpBean;
import com.mvc.util.BusinessClass;

public class ListEmpRangeDao {
	public List<EmpBean> listrange() {
		BusinessClass b = new BusinessClass();
		List<EmpBean> object = b.listrange();
		return object;
	}
}