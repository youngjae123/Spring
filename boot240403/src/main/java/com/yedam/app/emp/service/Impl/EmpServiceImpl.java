package com.yedam.app.emp.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	EmpMapper empMapper;

	@Override
	public List<EmpVO> empList() {
		return empMapper.selectEmpAll();
	}

	@Override
	public EmpVO empInfo(EmpVO empVO) {
		return empMapper.selectEmp(empVO);
	}

	@Override
	public int empInsert(EmpVO empVO) {
		int result = empMapper.insertEmp(empVO);
		if(result ==1 ) {
			return empVO.getEmployeeId();
		}else {
			return -1;
		}
	}

	@Override
	public Map<String, Object> empUpdate(EmpVO empVO) {
		// let map = {} ; == Map<String, Object> map = new HashMap<>();
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = empMapper.updataEmp(empVO);
		
		if(result == 1 ) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		// map.terget = { employeeId : '', last:'', ...} 
		map.put("target", empVO);
		return null;
	}

	@Override
	public Map<String, Object> empDelete(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		int result = empMapper.deleteEmp(empVO.getEmployeeId());
		
		if(result == 1) {
			map.put("employeeId",empVO.getEmployeeId());
		}
		
		
		return map;
	}
	
	
}
