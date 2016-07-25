package com.webank.working.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webank.working.web.dao.ProductDao;
import com.webank.working.web.dto.Product;

@Service
public class DemoService {

	@Autowired
	private ProductDao productDao;
	
	@Transactional(rollbackFor = Exception.class)
	public void add(Product product){
		productDao.insert(product);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Product selectProductById(int id){
		return productDao.getProductById(id);
	}
	
	public Product lockProduct(int id){
		return productDao.lockProduct(id);
	}
	
	public int updateProduct(Product record){
		return productDao.updateByPrimaryKeySelective(record);
	}
}
