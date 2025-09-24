package campus_cafe_project.model;

import java.util.*;
import java.math.BigDecimal;

public class Order 
{
	private List<LineItem> lineItems = new ArrayList<>();
	
	public Order()
	{
		
	}
	
	public void addLineItem(Product product)
	{
			LineItem item = new LineItem(product.getName(), product.getQuantity(), product.price(), product.getModifier());
			lineItems.add(item);
	}
		
	public BigDecimal calculateSalesTax()
	{
		BigDecimal salesTax = BigDecimal.valueOf(0);
		
		for(LineItem lineItem : lineItems)
		{
			salesTax = salesTax.add((lineItem.getCost().multiply(BigDecimal.valueOf(lineItem.getQuantity()))).multiply(BigDecimal.valueOf(.085)));
		}
		
		return salesTax;
	}	
}