package com.dse.cms.web.service;

import java.util.List;

import com.dse.cms.web.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dse.cms.web.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional(readOnly=true)
	public List<Department> getAll(){
		return departmentRepository.getAll();
	}
}
