package com.example.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex02Application2 implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ex02Application2.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/sample";;
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		    Class.forName( "org.mariadb.jdbc.Driver");
		    System.out.println("드라이버 로딩 성공");

		    conn = DriverManager.getConnection(url, user, password);
		    System.out.println("데이터베이스 연결 성공");

		    String sql = "select now() as now";
		    pstmt = conn.prepareStatement(sql);
		    rs = pstmt.executeQuery();

		    if(rs.next()) {
		        System.out.println("Current Timestamp: " + rs.getString("now"));
		    }

		} catch(ClassNotFoundException e ){
		    System.out.println( " [에러] " + e.getMessage() );
		} catch(SQLException e){
		    System.out.println( " [에러] " + e.getMessage() );
		} finally {
		    if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
		    if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
		    if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		
	}
}