package com.yedam.spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class Chef {
	public void cooking() {
		System.out.println("annotation 방식");
	}
}
