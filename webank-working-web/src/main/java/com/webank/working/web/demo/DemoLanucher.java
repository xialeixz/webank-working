package com.webank.working.web.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class DemoLanucher {
	
	public static void main(String[] args){
		try {
			System.out.println("开始context！！！");
			Log4jConfigurer.initLogging("classpath:log4j.properties");
			//init();
			ApplicationContext context 
				= new ClassPathXmlApplicationContext("classpath:spring-config.xml");
			String msg ="";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("网络异常！");
		}
	}
}
