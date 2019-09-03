package com.mvc.dao;

import com.mvc.util.BusinessClass;

public class DeleteEmpDao {
	public String deleteemp(String id) {
		BusinessClass b = new BusinessClass();
		String object = b.delete(id);
		return object;
	}
}
