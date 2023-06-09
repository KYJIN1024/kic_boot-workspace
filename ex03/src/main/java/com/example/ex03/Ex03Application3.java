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

@SpringBootApplication
public class Ex03Application3  implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Ex03Application3.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println( "Hello Spring BOOT : " + jdbcTemplate );

        List<String> databases = jdbcTemplate.query(
                "SHOW DATABASES",
                new RowMapper<String>() {
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getString(1);
                    }
                }
        );

        for(String database : databases) {
            System.out.println("Database: " + database);
        }
    }
}