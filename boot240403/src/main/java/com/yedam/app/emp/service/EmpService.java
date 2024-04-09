package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;


public interface EmpService {
	// 전체조회
	public List<EmpVO> empList();

	// 단권조회
	public EmpVO empInfo(EmpVO empVO);

	// 등록
	public int empInsert(EmpVO empVO);

	// 수정
	public Map<String, Object> empUpdate(EmpVO empVO);

	// 삭제
	public Map<String, Object> empDelete(EmpVO empVO);
	
	// 등록할 사원번호 조회
	public EmpVO getEmpId();
}
