package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.aop.service.AaaService;

@SpringBootTest
class Boot240417ApplicationTests {
	
	@Autowired
	AaaService aaaService;
	
	@Test
	public void aopTest() {
		aaaService.insert();
	}
}
