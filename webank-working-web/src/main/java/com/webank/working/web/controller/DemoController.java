package com.webank.working.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webank.working.web.dto.Product;

@Controller  
@RequestMapping("/user")
public class DemoController
{
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model){  
        Product product = new Product();
        product.setId(2);
        product.setName("呵呵哒");
        product.setDescription("拉娜丽娜的是的撒");
        product.setQuantity(3);
        model.addAttribute("product", product);  
        return "showUser";  
	}
}
