package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper") //Mapper 경로 설정(interface)/ xml은 application.properties에서 읽음
public class Boot240417Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot240417Application.class, args);
	}

}
