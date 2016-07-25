package com.webank.working.web.dao;

import com.webank.working.web.dto.Product;

public interface ProductDao
{
	public void insert(Product product);

	public Product getProductById(int id);

	public Product lockProduct(int id);
	
	int updateByPrimaryKeySelective(Product record);
}
