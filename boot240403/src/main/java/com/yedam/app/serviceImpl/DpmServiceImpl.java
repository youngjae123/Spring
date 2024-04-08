package com.yedam.app.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dpm.mapper.DpmMapper;
import com.yedam.app.dpm.service.DpmService;
import com.yedam.app.dpm.service.DpmVO;
@Service
public class DpmServiceImpl implements DpmService{

	@Autowired
	DpmMapper dpmMapper;
	
	@Override
	public List<DpmVO> dpmList() {
		return dpmMapper.selectDpmAll();
	}

	@Override
	public DpmVO dpmInfo(DpmVO dpmVO) {
		return dpmMapper.selectDpm(dpmVO);
	}

	@Override
	public int dpmInsert(DpmVO epmVO) {
		return dpmMapper.insertDpm(epmVO);
	}

	@Override
	public Map<String, Object> dpmUpdate(DpmVO dpmVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = dpmMapper.updateDpm(dpmVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", dpmVO);
		return null;
	}

	@Override
	public Map<String, Object> dpmDelete(DpmVO dpmVO) {
		Map<String, Object> map = new HashMap<>();
		int result = dpmMapper.deleteEmp(dpmVO.getDepartmentId());
		
		if(result == 1) {
			map.put("departmentId", dpmVO.getDepartmentId());
		}
		return map;
	}

}
