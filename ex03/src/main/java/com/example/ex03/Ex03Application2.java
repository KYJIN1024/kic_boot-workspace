package com.example.ex03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Ex03Application2  implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Ex03Application2.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println( "Hello Spring BOOT : " + jdbcTemplate );

        String result
            = jdbcTemplate.queryForObject("select now() as now", String.class );
        System.out.println("result :" + result);

    }

}