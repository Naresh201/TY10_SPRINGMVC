package com.te.springmvc.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.springmvc.beans.Product;
import com.te.springmvc.customexception.ProductException;

@ControllerAdvice
public class ProductControlAdvice {
	
	@ExceptionHandler(ProductException.class)
	public String handleExp(BeansException exception, HttpServletRequest request) {
		request.setAttribute("expMsg", exception.getMessage());
		return "header";
	}

}
