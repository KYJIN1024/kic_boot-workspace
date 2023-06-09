package com.example.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.controller"} )
public class BootUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootUploadApplication.class, args);
	}

}
