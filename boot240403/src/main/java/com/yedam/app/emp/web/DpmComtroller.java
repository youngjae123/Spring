package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.service.DpmService;
import com.yedam.app.emp.service.DpmVO;


@Controller
public class DpmComtroller {
	@Autowired
	DpmService dpmService;
	
	// 전체조회
	@GetMapping("dpmList")
	public String dpmList(Model model) {
		List<DpmVO> list = dpmService.dpmList();
		model.addAttribute("dpmList", list);
		return "dpm/list";
	}
	@GetMapping("dpmInfo")
	public String dpmInfo(DpmVO dpmVO, Model model) {
		DpmVO findVO = dpmService.dpmInfo(dpmVO);
		model.addAttribute("dpmInfo",findVO);
		return "dpm/info";
	}
	@GetMapping("dpmInsert")
	public String empInserProcess(DpmVO dpmVO) {
		int did = dpmService.dpmInsert(dpmVO);
		String uri = null;
		if(did > -1) {
			uri="redirect:dmpInfo?departmentId="+did;
		}else {
			uri="dpmList";
		}
		return uri;
	}
	}
