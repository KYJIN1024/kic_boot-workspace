package com.example.ex06;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex06Application implements CommandLineRunner {
	
	@Autowired
	private SqlSession sqlSession;

	public static void main(String[] args) {
		SpringApplication.run(Ex06Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "sqlSession" + sqlSession );
		
		String result = sqlSession.selectOne("select");
		System.out.println("result:" + result);

	}

}
