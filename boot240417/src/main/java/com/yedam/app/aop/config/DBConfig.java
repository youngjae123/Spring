package com.yedam.app.aop.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	
	@Bean
	public TransactionManager transactionManager(DataSource dataSource) {//TransactionManager는 별도로 빈을 등록해야 함 그러기 위해선 @EnableTransactionManagement 필요
		return new DataSourceTransactionManager(dataSource);
	}
}
