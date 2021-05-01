package com.te.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {
	
	/*
	 * this annotation is one way
	@RequestMapping(path="/first" , method=RequestMethod.GET)
	public ModelAndView getFirstPage() {
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("name","naresh" );
		modelandview.setViewName("/WEB-INF/views/app.jsp");
		return modelandview;
	}
	@RequestMapping(path="/search", method=RequestMethod.GET)
	public ModelAndView getSearch(ModelAndView modelAndView) {
		modelAndView.setViewName("/WEB-INF/views/user.jsp");
		modelAndView.setViewName("user");
		return modelAndView;
	}
	*/
	// this annotation is second way
	@GetMapping("/first1")
	public String getLoginPage(){
		return "/WEB-INF/views/login.jsp";
	}
	@PostMapping("/login")
	public String getData1(HttpServletRequest request,ModelMap map) {
		
	 String username = 	request.getParameter("username");
	 String password = request.getParameter("password");
	 map.addAttribute("username", username);
	 map.addAttribute("password", password);
		return "/WEB-INF/views/home.jsp";	
	}
	@PostMapping("/login2")
	public String getData2(@RequestParam (name="username") String username,@RequestParam (name="password") String password,ModelMap map) {
	 map.addAttribute("username", username);
	 map.addAttribute("password", password);
		return "/WEB-INF/views/home.jsp";		
	}
	@PostMapping("/login3")
	public String getData3(String username,String password,ModelMap map) {
		
	 map.addAttribute("username", username);
	 map.addAttribute("password", password);
		return "/WEB-INF/views/home.jsp";		
	}
	@PostMapping("/login4")
	public String getData4(UserBean bean,ModelMap map) {
		map.addAttribute("username",bean.getUsername());
		map.addAttribute("password",bean.getPassword());
		return "home";		
	}

}
