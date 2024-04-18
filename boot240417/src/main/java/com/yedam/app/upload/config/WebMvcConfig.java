package com.yedam.app.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	
	@Value("${file.upload.path}")
	private String uploadPath;
	// 리소스 핸들링
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**") // 주소
		.addResourceLocations("file:///"+ uploadPath,"");
				//.addResourceLocations("file:///C:/upload/",""); // addResourceLocations = 실제로 접근하는 경로 (물리적으로 접근하는) ,동일한 경로에 여러개 Mapping 가능
	}
	
}
