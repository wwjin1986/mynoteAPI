package com.weiweijin.myNoteAPI.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


	@Configuration
	@EnableWebMvc
	public class WebMvcConfig implements WebMvcConfigurer{

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("POST","GET","DELETE","PUT","HEADERS","OPTIONS")
				.allowedHeaders("*");
			}
		
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
		    registry.addResourceHandler("swagger-ui.html")
		      .addResourceLocations("classpath:/META-INF/resources/");
		 
		    registry.addResourceHandler("/webjars/**")
		      .addResourceLocations("classpath:/META-INF/resources/webjars/");
		}

	}

