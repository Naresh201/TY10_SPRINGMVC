package com.te.springmvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc.beans.AdminInfo;
import com.te.springmvc.beans.Product;
import com.te.springmvc.services.AdminServicesImp;

@Controller
public class AdminLoginController {
	
	@Autowired
	private AdminServicesImp service;
	
	@GetMapping("/admin")
	public String getLogin() {
		return "adminlogin";		
	}
	@PostMapping("/home")
	public String getHomePage(int id,String password ,HttpServletRequest request,ModelMap map) {
		
	       AdminInfo bean = 	service.autheticate(id, password);
	       
	       if(bean != null) {
	    	   HttpSession session = request.getSession(true);
	    	  session.setAttribute("loggedinfo", bean);
				return "home";
	    	   
	       }else {
	    	   System.out.println(" login failure");
				map.addAttribute("msg", " User Details Not Found");
	    	   return "adminlogin";
	       }
		
	}
	@GetMapping("/logout")
	public String handleLogout(HttpSession httpSession, ModelMap map) {
		httpSession.invalidate();
		map.addAttribute("msg", "logged out Successfully");
		return "adminlogin";
	}
	
	@GetMapping("/searchall")
	public String serchForAllProsucts(@SessionAttribute(name = "loggedInfo", required = false) AdminInfo bean,ModelMap map){
		if (bean != null) {
			List<Product> beans = service.getAllProductDetails();
			if (beans != null) {
				map.addAttribute("infobeans", beans);
				
			} else {
				map.addAttribute("msg", "No records Found");
			}
			return "searchPage";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "adminlogin";
		}
	}
	@GetMapping("/add")
	public String add(@SessionAttribute(name = "loggedInfo", required = false) AdminInfo bean,ModelMap map) {
		if (bean != null) {
			return "adding";	
			} else {
				map.addAttribute("msg", "No records Found");
			}
			return "adminlogin";
	}
	@PostMapping("/addproduct")
	public String addproducts(@SessionAttribute(name = "loggedInfo", required = false) AdminInfo bean,
			Product productinfo, ModelMap map) {
		if (bean != null) {
			if (service.addProducts(productinfo)){
				map.addAttribute("msg", "Employee Details Added");
			} else {
				map.addAttribute("errMsg", "Details already exists");
			}
			return "adding";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "adminlogin";
		}
}
	@GetMapping("/updating")
	public String updatingProducts(@SessionAttribute(name = "loggedInfo", required = false) AdminInfo bean,ModelMap map) {
		if (bean != null) {
			return "update";	
			} else {
				map.addAttribute("msg", "No records Found");
			}
			
			return "adminlogin";
	}
	
	@PostMapping("/updateproduct")
	public String updateproduct(@SessionAttribute(name = "loggedInfo", required = false) AdminInfo bean,
			Product productinfo, ModelMap map) {
		if (bean != null) {
			if (service.updateProduct(productinfo)){
				map.addAttribute("msg", "Employee Details Added");
			} else {
				map.addAttribute("errMsg", "Details already exists");
			}
			return "adding1";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "adminlogin";
		}
}
	
	@GetMapping("/delete")
	public String deleteProducts(@SessionAttribute(name = "loggedInfo", required = false) AdminInfo bean,ModelMap map) {
		if (bean != null) {
			return "delete";	
			} else {
				map.addAttribute("msg", "No records Found");
			}
			
			return "adminlogin";
	}
	@PostMapping("/deleteproduct")
	public String deleteproduct(@SessionAttribute(name = "loggedInfo", required = false) AdminInfo bean,
			int id , ModelMap map) {
		if (bean != null) {
			if (service.deleteProduct(id)){
				map.addAttribute("msg", "Employee Details Added");
			} else {
				map.addAttribute("errMsg", "Details already exists");
			}
			return "deleting";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "adminlogin";
		}
}
	
}
