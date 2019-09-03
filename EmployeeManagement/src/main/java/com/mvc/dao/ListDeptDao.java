
package com.mvc.dao;

import java.util.List;
import com.mvc.bean.EmpBean;
import com.mvc.util.BusinessClass;

public class ListDeptDao {
	public List<EmpBean> listdept() {
		BusinessClass b = new BusinessClass();
		List<EmpBean> object = b.listdept();
		return object;

	}
}
