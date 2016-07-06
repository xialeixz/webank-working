package com.webank.working.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController
{
	@RequestMapping(value = "/toPage.htm")
	public ModelAndView toPage()
	{
		return new ModelAndView("toPage");
	}
}
