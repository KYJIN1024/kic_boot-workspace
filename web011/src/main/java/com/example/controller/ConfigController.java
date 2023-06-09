package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
@Controller
public class ConfigController {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping( "/form.do" )
	public ModelAndView form() {
		return new ModelAndView( "form" );
	}
	
	@RequestMapping( "/form_ok.do" )
	public ModelAndView form_ok(HttpServletRequest request) {
		System.out.println("data :" + request.getParameter("data"));
		
		System.out.println( "dataSource :" + dataSource );
		System.out.println( "jdbcTemplate: " + jdbcTemplate );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form_ok");
		modelAndView.addObject("data", request.getParameter( "data" ) );
		return modelAndView;
	}
	
	
	/*
	@RequestMapping("/form_ok.do")
	public String form_ok(HttpServletRequest request, Model model) {
		
		model.addAttribute("data", request.getParameter("data"));
		System.out.println("data :" + request.getParameter("data"));
		return "form_ok";
	}
	*/
	
	
	
	
	
	
}
