package com.yedam.app;


import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yedam.app.aop.service.AaaService;

@SpringBootTest
class Boot240417ApplicationTests {
	
	@Autowired
	AaaService aaaService;
	
	//@Test
	public void aopTest() {
		aaaService.insert();
	}
	
	@Autowired
	PasswordEncoder passwordEncoder; // 단방향 암호화-> 복구화 불가능  양방향 암호화 -> 복구화 가능
	
	@Test
	public void testEncoder() {
		String password = "1234";
		
		String enPwd = passwordEncoder.encode(password); // 암호화 한다
		System.out.println("enPwd : " + enPwd);
		
		boolean matchResult = passwordEncoder.matches(password, enPwd); // 암호화한 값과 입력한 값이 같은지 확인함
		System.out.println("matchResult : " + matchResult);
		
	}
	
	@Autowired
	StringEncryptor jasyptStringEncryptor;
	
	@Test
	public void encryption() {
		String[] strs = {
				"net.sf.log4jdbc.sql.jdbcapi.DriverSpy",
				"jdbc:log4jdbc:oracle:thin:@127.0.0.1:1521:xe",
				"hr",
				"hr"
		};
		for(String str : strs) {
			String encStr = jasyptStringEncryptor.encrypt(str);
			System.out.println(encStr);
		}
	}
}
