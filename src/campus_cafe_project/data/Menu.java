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
		Food food = new Food("F01", "Breakfast Sandwich", BigDecimal.valueOf(4.50));
		items.add(food);
		food = new Food("F02", "Bagel", BigDecimal.valueOf(4.00));
		items.add(food);
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