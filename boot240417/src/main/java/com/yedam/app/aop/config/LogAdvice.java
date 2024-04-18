package com.yedam.app.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//빈으로 등록
@Aspect// Aop를 위한 빈이라는 어노테이션
@Component
public class LogAdvice {
	// 포인트컷: 비즈니스 로직과 관련된 메소드 중에서 Advice(공통 코드)가 적용될 메소드
	@Pointcut("within(com.yedam.app.emp.service.Impl.*)")//within 특정경로 밑에 모든 메서드에 대해 적용하겠다
	
	public void allPointCut() {} 
	
	// Weaving : 포인트컷 + Advice + 타이밍
	@Around("allPointCut()") 
	public Object logger(ProceedingJoinPoint joinPoint) throws Throwable{
		// Aop가 적용되는 메서드의 이름
		String signatuerStr = joinPoint.getSignature().toString();
		System.out.println("시작 : " + signatuerStr);
		
		//공통기능
		System.out.println("핵심 기능 전 실행 - 공통기능 : " + System.currentTimeMillis());
		
		try {
			Object obj = joinPoint.proceed(); // 실행 코드
			return obj;
		}finally {
			System.out.println("핵심 기능 후 실행 - 공통기능: " + System.currentTimeMillis());
			System.out.println("끝 : " + signatuerStr);
		}
	}
	@Before("allPointCut()")
	public void beforeAdvice(JoinPoint joinPoint) {
		String signatuerStr = joinPoint.getSignature().toString();
		System.out.println("시작 : " + signatuerStr);
		
	}
}
