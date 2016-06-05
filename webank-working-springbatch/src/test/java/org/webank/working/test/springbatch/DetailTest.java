package org.webank.working.test.springbatch;

import org.junit.Test;
import org.webank.working.springbatch.pojo.Product;

public class DetailTest
{
	@Test
	public void testMessageFormat()
	{
		Product product = new Product(2, "荣事达", "洗衣机", 1);
		System.out.println(product);
	}
}
