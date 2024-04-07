package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.DpmVO;

public interface DpmMapper {
	// 전체조회
		public List<DpmVO> selectDpmAll();
		
		// 단권조회
		public DpmVO selectDpm(DpmVO dpmVO);
		
		// 등록
		public int insertDpm(DpmVO dpmVO);
		
		//수정
		public int updateDpm(DpmVO dpmVO);
		
		//삭제
		public int deleteEmp(int departmentId);
}
