package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;

@Service // Aop가 적용가능한 Bean
public class AaaServiceImpl implements AaaService {

	@Autowired
	AaaMapper aaaMapper;
	
	@Transactional //@Service 밑에서 사용된다
	@Override
	public void insert() {
		aaaMapper.insert("101");
		aaaMapper.insert("a101");
		
	}

}
