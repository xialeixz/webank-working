package com.test.web.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

public class TestOther {

	@Test
	public void testFile() throws FileNotFoundException{
		FileInputStream in = 
				new FileInputStream("D:/develop/apache-tomcat-7.0.68/webapps/webank-working-web/WEB-INF/classes/main/resources/spring-config.xml");
		System.out.println(in);
	}
}
