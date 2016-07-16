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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath:spring-jdbc.xml" })
public class TestProductDao
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ProductDao dao;

	@Test
	public void insert()
	{
		Product product = new Product();
		product.setName("呵呵1");
		product.setDescription("我的爱");
		product.setQuantity(21);

		dao.insert(product);
	}
	
	@Test
	public void select(){
		Product product = dao.getProductById(1);
		System.out.println(product);
	}
}
