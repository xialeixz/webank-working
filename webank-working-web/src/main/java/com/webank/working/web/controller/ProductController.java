package com.webank.working.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.webank.working.web.service.ProductService;

@Controller  
@RequestMapping("/user")
public class ProductController
{
	@Autowired
	ProductService productService;
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model){  
		model.addAttribute("product", productService.selectProductById(new Integer(request.getParameter("id"))));
        return "showUser";  
	}
}
