package com.test.web.dao;

import org.apache.log4j.Level;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webank.working.web.dao.ProductDao;
import com.webank.working.web.dto.Product;
import com.webank.working.web.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath:spring-jdbc.xml" })
public class TestProductDao
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ProductService demoService;

	@Test
	public void lock(){
		
		Product product = demoService.lockProduct(1);
		product.setQuantity(product.getQuantity() + 1);
		demoService.updateProduct(product);
		
		product = demoService.selectProductById(1);
		logger.info("{}", product);
	}
	
	@Test
	public void insert()
	{
		Product product = new Product();
		product.setName("呵呵1");
		product.setDescription("我的爱");
		product.setQuantity(21);
	}
	
	@Test
	public void select(){
		Product product = new Product();
		product.setName("呵呵1");
		product.setDescription("我的爱");
		product.setQuantity(21);
		
		demoService.add(product);
		
		product = demoService.selectProductById(product.getId());
		System.out.println(product);
	}
}
