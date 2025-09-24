package campus_cafe_project.data;

import campus_cafe_project.model.*;
import java.math.BigDecimal;
import java.util.*;

public class Menu 
{	
	private List<Product> items = new ArrayList<>();
	
	public Menu() 
	{	
		buildMenu();
	}
	
	private void buildMenu() 
	{	
		Beverage beverage = new Beverage("B01", "Coffee", BigDecimal.valueOf(2.50));
		items.add(beverage);	
		beverage = new Beverage("B02", "Tea", BigDecimal.valueOf(3.50));
		items.add(beverage);
	}
	
	public void displayMenu() 
	{	
		System.out.println("Select from the menu options below . . .");
		
		for(Product item: items)
		{
			System.out.println(String.format("%s -- %s: $%,.2f", item.getId(), item.getName(), item.getBasePrice()));
		}
	}
	
	public Product getMenuItem(String id)
	{
		for(Product item: items)
		{
			if(item.getId().equalsIgnoreCase(id))
			{
				return item;
			}
		}
		
		return null;
	}
}