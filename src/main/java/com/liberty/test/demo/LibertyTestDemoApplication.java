package com.liberty.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.liberty.test")
public class LibertyTestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibertyTestDemoApplication.class, args);
	}

}
