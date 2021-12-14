package com.example.springlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		"com.example.springlogin.Controller", "com.example.springlogin.dao","com.example.springlogin.dto","com.example.springlogin"
})
@SpringBootApplication
public class SpringloginApplication {

	public static void main(String[] args) {
		System.out.println("Hi, when does this load");

		SpringApplication.run(SpringloginApplication.class, args);
	}

}
