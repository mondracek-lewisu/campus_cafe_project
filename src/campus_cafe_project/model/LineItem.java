package campus_cafe_project.model;

import java.math.BigDecimal;

public class LineItem 
{
	private String name;
	private int quantity;
	private BigDecimal cost;
	private String addon;
	
	public LineItem(String name, int quantity, BigDecimal cost, String addon)
	{
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
		this.addon = addon;
	}
	
	public BigDecimal getCost()
	{
		return this.cost;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getAddon()
	{
		return this.addon;
	}
}