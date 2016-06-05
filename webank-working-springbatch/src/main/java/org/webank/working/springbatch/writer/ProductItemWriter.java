package org.webank.working.springbatch.writer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.webank.working.springbatch.pojo.Product;

public class ProductItemWriter implements ItemWriter<Product>
{
	private static final String GET_PRODUCT = "SELECT * FROM PRODUCT WHERE id = ?";

	private static final String INSERT_PRODUCT = "INSERT INTO PRODUCT (id, name, description, quantity) VALUES ({0,number},{1},{2},{3,number})";

	private static final String UPDATE_PRODUCT = "UPDATE PRODUCT SET name = {0}, description = {1}, quantity = {2,number} WHERE id = {3}";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void write(List<? extends Product> items) throws Exception
	{
		if (null == items || 0 == items.size())
			return;

		for (Product product : items)
		{
			@SuppressWarnings("unchecked")
			List<Product> productList = jdbcTemplate.query(GET_PRODUCT, new Object[]
			{ product.getId() }, new RowMapper()
			{

				public Object mapRow(ResultSet arg0, int arg1) throws SQLException
				{
					return new Product(arg0.getInt(0), arg0.getString(1), arg0.getString(2), arg0
					        .getInt(3));
				}
			});

			if (productList.size() > 0)
			{
				jdbcTemplate.update(MessageFormat.format(UPDATE_PRODUCT, product.getName(),
				        product.getDescription(), product.getQuantity(), product.getId()));
			}
			else
			{
				jdbcTemplate.update(MessageFormat.format(INSERT_PRODUCT, product.getId(),
				        product.getName(), product.getDescription(), product.getQuantity()));
			}
		}

		return;
	}
}
