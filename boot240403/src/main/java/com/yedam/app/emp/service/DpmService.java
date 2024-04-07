package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

public interface DpmService {
	// 전체조회
		public List<DpmVO> dpmList();
		// 단건조회
		public DpmVO dpmInfo(DpmVO dpmVO);
		// 등록
		public int dpmInsert(DpmVO epmVO);
	    // 수정
		public Map<String, Object> dpmUpdate(DpmVO dpmVO);
		//삭제
		public Map<String, Object> dpmDelete(DpmVO dpmVO);
}
