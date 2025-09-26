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
			salesTax = salesTax.add(lineItem.getCost().multiply(BigDecimal.valueOf(.085)));
		}
		
		return salesTax;
	}
	
	public BigDecimal calculateSubtotal()
	{
		BigDecimal subtotal = BigDecimal.valueOf(0);
		
		for(LineItem lineItem : lineItems)
		{
			subtotal = subtotal.add(lineItem.getCost());
		}
		
		return subtotal;
	}

	public String formatItems()
	{
		String output = "";
		
		for(LineItem lineItem : lineItems)
		{
			output += (String.format("%dx %s (%s) - $%.2f\n",lineItem.getQuantity(),lineItem.getName(),lineItem.getAddon(),lineItem.getCost()));
		}
		
		return output;
	}
}