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
	
	public void printReceipt()
	{
		System.out.print("\nYour order:\n");
		for(LineItem lineItem : lineItems)
		{
			System.out.println(String.format("%dx %s (%s) - $%.2f",lineItem.getQuantity(),lineItem.getName(),lineItem.getAddon(),lineItem.getCost()));
		}
		System.out.println(String.format("Subtotal: $%.2f",calculateSubtotal()));
		System.out.println(String.format("Sales Tax: $%.2f",calculateSalesTax()));
		System.out.print(String.format("Total: $%.2f",calculateSubtotal().add(calculateSalesTax())));
	}
}