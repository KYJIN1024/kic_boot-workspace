package com.example.bootjdbctemplateboard;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.bootjdbctemplateboard" ,"com.example.controller", "com.example.model" })
public class BootJdbcTemplateBoardApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BootJdbcTemplateBoardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
