package com.yedam.java.emp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.emp.mapper.EmpMapper;
import com.yedam.java.emp.service.EmpService;
import com.yedam.java.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {

	/*
	 * @Autowired public EmpServiceImpl(EmpMapper empMapper) { this.empMapper =
	 * empMapper; }
	 */

	@Autowired
	EmpMapper empMapper;
	
	@Override
	public List<EmpVO> empAllList() {
		return empMapper.selectEmpAll();
	}

}
