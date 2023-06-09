package com.example.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex03Application  implements CommandLineRunner {
	
	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(Ex03Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		    conn = this.dataSource.getConnection();

		    String sql = "select now() as now";
		    pstmt = conn.prepareStatement(sql);
		    rs = pstmt.executeQuery();

		    if(rs.next()) {
		        System.out.println("Current Timestamp: " + rs.getString("now"));
		    }

		} catch(SQLException e){
		    System.out.println( " [에러] " + e.getMessage() );
		} finally {
		    if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
		    if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
		    if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		System.out.println( "Hello Spring Boot" + dataSource );
	}
}