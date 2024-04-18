package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")// GET = 빈페이지나 무언가를 조회할때 씀
	public String homePage() {
		return "home"; //home이라는 파일을 리턴 경로는 template 밑에 ( application.properties에서 경로(classpath:/templates/)를 확인하고 써야한다)(##spring.thymeleaf.prefix의 기본경로 확인)
		//classpath:/templates/home/html.html (spring.thymeleaf.suffix = .html)
	}
}
