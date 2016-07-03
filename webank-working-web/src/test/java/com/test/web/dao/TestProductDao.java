package com.test.web.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
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
}
