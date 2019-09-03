package com.mvc.dao;

import java.util.List;
import com.mvc.bean.EmpBean;
import com.mvc.util.BusinessClass;

public class ListReportingManagerDao {
	public List<EmpBean> listreport(String listreport) {
		BusinessClass b = new BusinessClass();
		List<EmpBean> object = b.listreport(listreport);
		return object;
	}
}
