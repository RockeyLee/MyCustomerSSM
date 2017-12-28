package com.rockey.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// TODO Auto-generated method stub
		CustomException customException  = null;
		ModelAndView mv = new ModelAndView();
		if(ex instanceof CustomException){
			customException = (CustomException)ex;
		}else{
			customException = new CustomException("未知错误，请与管理员联系");
		}
		String  message = customException.getMessage();
		
		mv.addObject("message", message);
		mv.setViewName("exception/error");
		return mv;
	}

}
