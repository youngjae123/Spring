package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import groovy.lang.Delegate;

@RestController // ==@Controller + 모든 메소드에 @ResponseBody를 적용
//모든 메서드에 @RequestBody가 적용 되어 있음
public class EmpRestController {
	@Autowired
	EmpService empService;
	
	// AJAX를 쓰려면 @RequestBody를 써야함
	
	//전체조회
	@GetMapping("emps") // 주소
	public List<EmpVO> empList(){ // Model model을 사용하지 않음
		return empService.empList();
	}
	//단건조회
	@GetMapping("emps/{id}") // 특정 대상에 대한 경우 경로에 {} 사용 [0.5_스프링 ppt 18P 참고], {}안의 값은 임의값이라도 무조건 있어야 한다
	
	//public EmpVO empInfo(@PathVariable Integer id) { //변수와 경로의 {}안의 이름을 같게한다(달라도 상관은 없다\)
	public EmpVO empInfo(@PathVariable(name="id") Integer employeeId ) {//@PathVariable 경로에서 값을 꺼낸다. 기본타입을(Integer, String 등) 써야하고 필수값이다
		EmpVO findVO = new EmpVO();
		findVO.setEmployeeId(employeeId);
		
		return empService.empInfo(findVO);
	}
	
	//등록 - POST
	@PostMapping("emps")//@RequestBody를 사용하면 POST형식으로 해야한다
	public int empInsert(@RequestBody EmpVO empVO) { //@RequestBody를 사용하면 무조건 JSON포맷으로 받아야한다.
		return empService.empInsert(empVO);
	}
	
	//수정 - PUT 수정 = 단권조회 + 등록
	@PutMapping("emps/{id}")
	public Map<String, Object> empUPdate(@PathVariable(name="id") Integer employeeId, @RequestBody EmpVO empVO) { 
		
		empVO.setEmployeeId(employeeId);
		
		return empService.empUpdate(empVO);
	}
	
	//삭제 - DELETE
	@DeleteMapping("emps/{id}")
	public Map<String, Object> empDelete(@PathVariable Integer id){
		EmpVO findVO = new EmpVO();
		findVO.setEmployeeId(id);
		
		return empService.empDelete(findVO);
	}
	
	
}
