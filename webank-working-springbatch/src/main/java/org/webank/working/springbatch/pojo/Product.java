package org.webank.working.springbatch.pojo;

import java.text.MessageFormat;

public class Product
{
	private int id;
	private String name;
	private String description;
	private int quantity;

	public Product(int id, String name, String description, int quantity)
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;

	}

	@Override
	public String toString()
	{
		return MessageFormat.format(
		        "Product[id：{0, number}，name：{1}，description：{2}，quantity：{3, number}]", this.id,
		        this.name, this.description, this.quantity);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
}
