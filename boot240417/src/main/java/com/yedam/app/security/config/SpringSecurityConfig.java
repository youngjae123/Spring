package com.yedam.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 설정이라는 어노테이션
@EnableWebSecurity // security 어노테이션
public class SpringSecurityConfig {

	// 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 원래는 안씀 (수업 테스트)
	// 메모리상 인증정보 활용
	//@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsService() {
		UserDetails user = User.builder().username("user1").password(passwordEncoder().encode("1234"))
				.roles("USER", "SALES")// roles("USER") => ROLE_USER (.authorities("ROLE_USER"))
				.build();
		return new InMemoryUserDetailsManager(user);
	}

	// 인증 및 인가 설정
	@Bean
	SecurityFilterChain fileterChain(HttpSecurity http) throws Exception {
		/*
		 * http.authorizeHttpRequests() // 위에서 아래로 검색함 .antMatchers("/","/all") // 경로등록
		 * .permitAll() // 인증 받지 않은 모든 대상들에 대한 인증을 허용하는 메서드
		 * .antMatchers("/user/**").hasRole("USER") //ROLE_USER
		 * .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
		 * .anyRequest().authenticated(); //인증된 대상
		 * 
		 * http.formLogin().defaultSuccessUrl("/all");
		 * http.logout();
		 */

		http.authorizeHttpRequests() // 위에서 아래로 검색함
					.antMatchers("/", "/all") // 경로등록
					.permitAll() // 인증 받지 않은 모든 대상들에 대한 인증을 허용하는 메서드
					.antMatchers("/user/**").hasAnyRole("USER","ADMIN")// hasAnyRole 둘 다 권한 허용
					//.antMatchers("/user/**").hasRole("USER") // ROLE_USER 하나만 허용
					.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
					.anyRequest().authenticated()
				.and()
				.formLogin()
					.defaultSuccessUrl("/all") // 인증된 대상
				.and()
				.logout()
				 	.logoutSuccessUrl("/all"); // 로그아웃했을때 첫페이지로 돌아가게 함

			http.csrf();
		// http.csrf().disable(); 

		return http.build();
	}
}
