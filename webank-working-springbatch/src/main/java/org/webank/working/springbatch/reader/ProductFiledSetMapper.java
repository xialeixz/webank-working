package org.webank.working.springbatch.reader;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;
import org.webank.working.springbatch.pojo.Product;

public class ProductFiledSetMapper implements FieldSetMapper<Product>
{
	public Product mapFieldSet(FieldSet fieldSet) throws BindException
	{
		return new Product(fieldSet.readInt("id"), fieldSet.readString("name"),
		        fieldSet.readString("description"), fieldSet.readInt("quantity"));
	}
}
