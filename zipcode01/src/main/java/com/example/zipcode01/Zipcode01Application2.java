package com.example.zipcode01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.model1.ZipcodeDAO;
import com.example.model1.ZipcodeTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan( {"com.example.model1"} )
public class Zipcode01Application2 implements CommandLineRunner {

    @Autowired
    private ZipcodeDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(Zipcode01Application2.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
     
    	String strDong = "대치";
    	
    	/*
    	String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";
    	ArrayList<ZipcodeTO> lists = (ArrayList<ZipcodeTO>)jdbcTemplate.query(
    			sql,
    			new BeanPropertyRowMapper<ZipcodeTO>(ZipcodeTO.class),
    			StrDong + "%" );
      
    	System.out.println( "갯수 : " + lists.size() );
    	
        	for (ZipcodeTO to : lists ) {
          	System.out.println( to.getZipcode() );
            System.out.println( to.getSido() );
           
        }
     	*/
    	System.out.println("dao: " + dao);
    	System.out.println("dao: " + dao.zipcodeList("개포"));
    	
    	ArrayList<ZipcodeTO> lists = dao.zipcodeList("개포");
    	for( ZipcodeTO to : lists ) {
    	System.out.println( to.getZipcode());
    	System.out.println( to.getSido());
    	}
    }

}