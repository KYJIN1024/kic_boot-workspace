package com.example.bootmybatisboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.bootmybatisboard","com.example.config","com.example.controller","com.example.model"})
public class BootMyBatisBoardApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BootMyBatisBoardApplication.class, args);
	}

}
