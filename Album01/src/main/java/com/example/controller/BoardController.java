package com.example.controller;

import com.example.model.BoardDAO;
import com.example.model.BoardTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

// @RestController 어노테이션은 이 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타냅니다.
@RestController
public class BoardController {
	// BoardDAO 객체를 저장하는 변수입니다. 이 변수는 생성자를 통해 초기화됩니다.
	private final BoardDAO dao;
	
	// 생성자. BoardDAO 객체를 주입받습니다.
	public BoardController(BoardDAO dao) {
		this.dao = dao;
	}
	
	// 루트 URL('/')에 대한 요청을 처리하는 메소드입니다.
	@RequestMapping( "/" )
	public ModelAndView root(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		// 뷰 이름을 "board_index1"로 설정합니다.
		modelAndView.setViewName( "board_index1" );
		
		// ModelAndView 객체를 반환합니다. 이 객체는 뷰와 모델 정보를 담고 있습니다.
		return modelAndView;
	}
	
	// '/list.do' URL에 대한 요청을 처리하는 메소드입니다.
	@RequestMapping( "/list.do" )
	public ModelAndView list(HttpServletRequest request) {
		// BoardDAO를 통해 게시글 목록을 가져옵니다.
		ArrayList<BoardTO> lists = dao.boardList();
		
		ModelAndView modelAndView = new ModelAndView();
		// 뷰 이름을 "board_list1"로 설정합니다.
		modelAndView.setViewName( "board_list1" );
		// 모델에 "lists"라는 이름으로 게시글 목록을 추가합니다.
		modelAndView.addObject( "lists", lists );
		
		// ModelAndView 객체를 반환합니다.
		return modelAndView;
	}
	
	// '/write.do' URL에 대한 요청을 처리하는 메소드입니다.
	@RequestMapping( "/write.do" )
	public ModelAndView write(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		// 뷰 이름을 "board_write1"로 설정합니다.
		modelAndView.setViewName( "board_write1" );
		
		// ModelAndView 객체를 반환합니다.
		return modelAndView;
	}
	
	// '/write_ok.do' URL에 대한 요청을 처리하는 메소드입니다.
	@RequestMapping( "/write_ok.do" )
	public ModelAndView write_ok(HttpServletRequest request) {
		// HttpServletRequest 객체를 이용해서 폼 데이터를 가져옵니다.
		BoardTO to = new BoardTO();
		to.setSubject( request.getParameter( "subject" ) );
		to.setWriter( request.getParameter( "writer" ) );
		
		// 이메일은 mail1 파라미터와 mail2 파라미터를 합쳐서 만듭니다.
		String mail = "";
		if( !request.getParameter( "mail1" ).equals("") && !request.getParameter( "mail2" ).equals("") ) {
			mail = request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" );
		}
		to.setMail( mail );
		to.setPassword( request.getParameter( "password" ) );
		to.setContent( request.getParameter( "content" ) );
		to.setWip( request.getRemoteAddr() );
		
		// BoardDAO를 통해 게시글을 작성하고 결과를 가져옵니다.
		int flag = dao.boardWriteOk( to );
		
		ModelAndView modelAndView = new ModelAndView();
		// 뷰 이름을 "board_write1_ok"로 설정합니다.
		modelAndView.setViewName( "board_write1_ok" );
		// 모델에 "flag"라는 이름으로 결과를 추가합니다.
		modelAndView.addObject( "flag", flag );
		
		// ModelAndView 객체를 반환합니다.
		return modelAndView;
	}
}