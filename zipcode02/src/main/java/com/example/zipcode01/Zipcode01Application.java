package com.example.zipcode01;

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
public class Zipcode01Application implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Zipcode01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> results = jdbcTemplate.query(
                "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?",
                new RowMapper<String>() {
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getString("zipcode") + ", " + rs.getString("sido") + ", " +
                               rs.getString("gugun") + ", " + rs.getString("dong") + ", " +
                               rs.getString("ri") + ", " + rs.getString("bunji");
                    }
                },
                "%부평%"  
        );

        for (String result : results) {
            System.out.println("result: " + result);
        }
    }
}