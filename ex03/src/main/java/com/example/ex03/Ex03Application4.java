package com.example.ex03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Ex03Application4  implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Ex03Application4.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println( "Hello Spring BOOT : " + jdbcTemplate );

        List<Map<String, Object>> results
        	= jdbcTemplate.queryForList("show databases");
        for( Map<String, Object> result : results ) {
        	System.out.println(result.get("Database"));
        }
        

    }
}