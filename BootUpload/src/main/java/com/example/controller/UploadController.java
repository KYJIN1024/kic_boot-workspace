package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UploadController {

	@GetMapping("/form.do")
	public ModelAndView mail(HttpServletRequest request) {
		
		//System.out.println(System.currentTimeMillis());
		//System.out.println(System.nanoTime());
		// uuid
		//System.out.println( UUID.randomUUID().toString());
		// session id 
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form");
		return modelAndView;
	}
	
	@PostMapping("/form_ok.do")
	public ModelAndView form_ok(@RequestParam("upload") MultipartFile upload) {
		
		try {
			System.out.println(upload.getOriginalFilename());
			System.out.println(upload.getSize());
			
			// 중복파일 제거 루틴 만들기
			// 파일명_타임스탬프, 확장자
			
			// 파일명 / 확장자 분리
			// xxx.jpg  

			
			String extension = upload.getOriginalFilename().substring(
								upload.getOriginalFilename().lastIndexOf(".") );
					
			String filename = upload.getOriginalFilename().substring(
								0, upload.getOriginalFilename().lastIndexOf(".") );
					
			//System.out.println( extension );
			//System.out.println( filename  );
			long timestamp = System.currentTimeMillis();
			
			String newfilename = filename + "-" + timestamp + extension;
			
			upload.transferTo( new File(newfilename ));
					
			
			/*
			String originalFilename = upload.getOriginalFilename();

			String filename = originalFilename.substring(0, originalFilename.lastIndexOf("."));
			
			// Avoiding filename collisions by appending current timestamp
			String newFilename = filename + "_" + System.currentTimeMillis();
			
			upload.transferTo(new File("d:/java/" + newFilename));
			*/
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form_ok");
		return modelAndView;
	}
	
	@GetMapping("/form_ok3.do")
	public ModelAndView form_ok3(MultipartFile[] uploads) {
		
		//System.out.println(System.currentTimeMillis());
		//System.out.println(System.nanoTime());
		// uuid
		//System.out.println( UUID.randomUUID().toString());
		// session id 
		
		//System.out.println( uploads.length );
		for( MultipartFile upload : uploads ) {
			System.out.println( upload.getOriginalFilename() );
		}
	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form_ok");
		return modelAndView;
	
	}
}