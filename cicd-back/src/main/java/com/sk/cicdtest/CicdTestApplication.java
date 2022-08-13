package com.sk.cicdtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CicdTestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CicdTestApplication.class, args);
		System.out.println("Hello");
	}

	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources(CicdTestApplication.class);
	}

}
