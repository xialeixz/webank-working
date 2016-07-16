package com.webank.working.web.dto;

import org.slf4j.helpers.MessageFormatter;

public class Product
{
	private Integer id;
	private String name;
	private String description;
	private Integer quantity;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
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

	public Integer getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}
	
	public String info(String format, Object... argArray) {
		return MessageFormatter.arrayFormat(format, argArray).getMessage();
    }
	
	@Override
	public String toString(){
		return info("{}-{}-{}", this.name, this.description, this.quantity);
	}
}
