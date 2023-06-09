package com.example.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

@RestController
public class MailController {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@RequestMapping("/mail.do")
	public ModelAndView mail(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "mail" );
		return modelAndView;
	}
	
	@RequestMapping("/mail_ok.do")
	public ModelAndView mail_ok(HttpServletRequest request) {
		
		System.out.println( "javaMailSender:" + javaMailSender );
		
		String toEmail = "";
		String toName = "테스터";
		String subject = "테스트 제목";
		String content = "<h1>테스트 내용<h1>";
				
		this.mailSender2(toEmail, toName, subject, content);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "mail_ok" );
		return modelAndView;
	}
	
	public void mailSender1(String toEmail, String toName, String subject, String content) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setTo( toEmail );
		simpleMailMessage.setSubject( subject );
		simpleMailMessage.setText( content );
		simpleMailMessage.setSentDate( new Date() );
		
		javaMailSender.send( simpleMailMessage );
		
		System.out.println( "전송 완료" );
	}
	
	public void mailSender2( String toEmail, String toName, String subject, String content) {
		
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			mimeMessage.addRecipient( RecipientType.TO, new InternetAddress( toEmail, toName, "utf-8"));
			
			mimeMessage.setSubject( subject, "utf-8" );
			mimeMessage.setText( content, "utf-8", "html" );
			
			mimeMessage.setSentDate( new Date() );
			
			javaMailSender.send( mimeMessage );
			
			System.out.println( "전송 완료" );
			
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
