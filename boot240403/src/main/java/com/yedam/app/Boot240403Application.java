package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
/*
 Spring Boot에서 어플리케이션을 실행하는 중요한 역할을 담당한다.
 타입 선언시 적용되며, 런타임간 JVM에서 참조가 되며 
 @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan 조합으로 
 어플리케이션에 필요한 모든 Configuration 또는 Component들을 Bean으로 생성해 Spring Container에 담고, 
 이를 이용하여 어플리케이션을 실행시킨다.
 
 */
@MapperScan(basePackages = "com.yedam.app.**.mapper")
//@MapperScan == 매퍼를 하나씩 등록하는게 아닌 페키지 경로를 지정하여 이하 위치에있는 인터페이스들은 전부 맵퍼로 사용할수있다.

public class Boot240403Application {

	public static void main(String[] args) {
		// 메인메소드는 자바 어플리케이션 실행시 제일 먼저 작하며 어느 객체에서든 접근할 수 있으며 자바가 컴파일 되는 순간 정의되는 돌려주는 값이 없는 참수
		SpringApplication.run(Boot240403Application.class, args);
	}

}
