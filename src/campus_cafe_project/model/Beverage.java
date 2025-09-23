package campus_cafe_project.model;

import java.math.BigDecimal;

public class Beverage extends Product
{
	private BeverageSize beverageSize;
	
	public Beverage(String id, String name, BigDecimal basePrice) 
	{
		super(id, name, basePrice); 	
	}	

	public void setBeverageSize(BeverageSize beverageSize)
	{
		this.beverageSize = beverageSize;
	}
	
	public BigDecimal price() 
	{
		BigDecimal price = this.getBasePrice().add(beverageSize.getSurcharge());
		return price.multiply(BigDecimal.valueOf(this.getQuantity()));
	}
}