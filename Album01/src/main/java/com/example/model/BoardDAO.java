package com.example.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BoardDAO {
	private final SqlSession sqlSession;
	
	public BoardDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public ArrayList<BoardTO> boardList() {
		// MyBatis를 사용하여 게시물 목록을 가져오는 쿼리를 실행합니다.
		return new ArrayList<>(sqlSession.selectList("boardList"));
	}
	
	public int boardWriteOk(BoardTO to) {
		// MyBatis를 사용하여 게시물을 작성하는 쿼리를 실행합니다.
		return sqlSession.insert("boardWrite", to);
	}
}