package com.yedam.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.dpm.service.DpmService;
import com.yedam.app.dpm.service.DpmVO;


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
	public String dpmInsertForm(Model model) {
		model.addAttribute("dpmVO",new DpmVO());
		return "dpm/insert";
	}
	@PostMapping("dpmInsert")
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
