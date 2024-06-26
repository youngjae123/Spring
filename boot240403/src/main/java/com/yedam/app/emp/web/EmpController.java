package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller // 결과 받아서 리턴
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	// GET	: 조회, 빈페이지
	// POST	: 데이터 조작(등록, 수정, 삭제)
	
	// 전체조회
	@GetMapping("empList")
	public String empList(Model model) {// Model = Response대용
		// Model = Request + Response
		// 1) 해당 기능 수행 -> Service
		List<EmpVO> list = empService.empList();
		// 2) 클라이언트에 전달할 데이터 담기
		model.addAttribute("empList",list);
		// 3) 데이터를 출력할 페이지 선택
		return "emp/list";
		// classpath == src/main/resources
		// 타임리프가 가지고 있는 prefix => classpath:/templates/
		// subfix => .html
		
		
	}
	
	//단건조회
	@GetMapping("empInfo") // 커맨드 객체(어노테이션이 아무거도 붙지 않는경우) => QueryString 형식으로 값을 넘겨달라는 말
	public String empInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("empInfo",findVO);
		return "emp/info"; 
	}
	
	//등록- 페이지 => GET
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		EmpVO empVO = empService.getEmpId();
		model.addAttribute("empVO", empVO);
		return "emp/insert";
	}
	//등록- 처리 =>POST
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.empInsert(empVO);
		String uri = null;
		if(eid > -1) {
			uri="redirect:empInfo?employeeId="+eid;
		}else {
			uri="empList";
		}
		return uri;
	}
	
	//수정 - 페이지
	@GetMapping("empUpdate")
	public String empUpdateForm(@RequestParam Integer employeeId,
								Model model) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("empInfo",findVO);
		
		return"emp/update";
	}
	
	//수정 - 처리 : AJAX => QueryString
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, Object> empUpdateProcess(EmpVO empVO) {
		
		return empService.empUpdate(empVO);
	}
	
	/*
	 * //수정 - 처리 : AJAX => JSON
	 * 
	 * @PostMapping("empUpdate")
	 * 
	 * @ResponseBody public Map<String, Object> empUpdateProcessAjax(@RequestBody
	 * EmpVO empVO) {
	 * 
	 * return empService.empUpdate(empVO); }
	 */
	
	// 삭제 - 처리
	@GetMapping("empDelete")
	public String empDelete(EmpVO empVO) {
		empService.empDelete(empVO);
		return "redirect:empList";
		
	}
}
