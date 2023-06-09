package com.example.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<BoardTO> boardList() {
		String sql = "select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board1 order by seq desc";
		ArrayList<BoardTO> lists = (ArrayList<BoardTO>)sqlSession.query(
			sql
			, new BeanPropertyRowMapper<BoardTO>(BoardTO.class));
				
		return lists;		
	}
	
	public int boardWriteOk(BoardTO to ) {
		int flag = 1;
		
		int result = sqlSession.insert("write_ok", to); 
		
		if( result == 1 ) {
			flag = 0;
		}
		
		return flag;
	}
	
	
}
