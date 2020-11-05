package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// @ControllerAdvice : 해당 클래스가 컨트롤러에 발생하는 모든 예외를
//  처리하는 클래스
@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

//	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
//	public String commonNum(Exception e) {
//		
//		logger.info("E : commonNum(e) 호출!!!! ");
//		logger.info("E : "+e);
//		
//		return "";
//	}

	// Exception 객체 처리
	/*
	 * @ExceptionHandler(Exception.class) public String common(Exception e ,Model
	 * model ) { // * CommonExceptionAdvice 객체에서는 Model객체를 // 파라미터로 사용하는것을 지원X // =>
	 * ModelAndView 객체를 사용
	 * 
	 * logger.info("E : common(e) 호출!!!! "); logger.info("E : "+e);
	 * 
	 * model.addAttribute("e", e);
	 * 
	 * return "common_error"; }
	 */
	
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception e) {
		
		logger.info("E : errorModelAndView(e) 호출");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common_error");
		mav.addObject("e", e);		
		
		return mav;
	}
	

}
