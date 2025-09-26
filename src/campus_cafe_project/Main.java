package campus_cafe_project;

import campus_cafe_project.data.*;
import campus_cafe_project.model.*;
import java.util.Scanner;

public class Main 
{
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{	
		Order order = new Order();
		Menu menu = new Menu();
		System.out.println("\nWelcome to the Campus Cafe\n");
		String menuOption = getMenuOption(menu);
		
		while(!menuOption.trim().equalsIgnoreCase("end"))
		{	
			Product item = menu.getMenuItem(menuOption);
			
			while(item == null)
			{
				System.out.println("\nYour selection is invalid.\n");
				item = menu.getMenuItem(getMenuOption(menu));
			}
			
			System.out.print("\nQuantity: ");
			int quantity = 0;
			
			while(!sc.hasNextInt() || (quantity = sc.nextInt())<=0)
			{
				sc.nextLine();
				System.out.print("\nInvalid Quantity.\nQuantity: ");
			}
		
			sc.nextLine();
			item.setQuantity(quantity);
			
			if(item instanceof Beverage)
			{
				BeverageSize beverageSize = getBeverageSize();
				while(beverageSize == null)
				{
					System.out.println("\nInvalid Entry");
					beverageSize = getBeverageSize();
				}
				((Beverage) item).setBeverageSize(beverageSize);
			}
			if(item instanceof Food)
			{
				FoodAddon foodAddon = getFoodAddon();
				while(foodAddon == null)
				{
					System.out.println("\nInvalid Entry");
					foodAddon = getFoodAddon();
				}
				((Food) item).setFoodAddon(foodAddon);
			}
			
			System.out.println(String.format("\nYou selected: %s -- %s -- $%.2f -- %s -- x%d -- total price: $%.2f\n",
					item.getId(), item.getName(), item.getBasePrice(), item.getModifierExtra(), item.getQuantity(), item.price()));
			order.addLineItem(item);
			
			menuOption = getMenuOption(menu);
		}
		
		System.out.println("\nYour order:");
		System.out.print(order.formatItems());
		System.out.print(String.format("\nSubtotal: $%.2f\nSales Tax: $%.2f\nTotal: $%.2f",
				order.calculateSubtotal(),order.calculateSalesTax(),order.calculateSubtotal().add(order.calculateSalesTax())));
	}
	
	private static String getMenuOption(Menu menu)
	{
		menu.displayMenu();
		System.out.print("\nPlease make a selection (or type 'end' to finish): ");
		return sc.nextLine();
	}
	
	private static BeverageSize getBeverageSize()
	{
		System.out.print("\nPlease Select (S)mall, (M)eduim, or (L)arge): ");
		String sizeOption = sc.nextLine();
		sizeOption = sizeOption.trim().toUpperCase();
		
		if(sizeOption.equals("M") || sizeOption.startsWith("MEDIUM"))
		{
			return BeverageSize.MEDIUM;
		}
		else if(sizeOption.equals("S") || sizeOption.startsWith("SMALL"))
		{
			return BeverageSize.SMALL;
		}
		else if(sizeOption.equals("L") || sizeOption.startsWith("LARGE"))
		{
			return BeverageSize.LARGE;
		}
		return null;
	}
	
	private static FoodAddon getFoodAddon()
	{
		System.out.print("\nThe following are all available addons:\nAdd (C)heese\nNo (M)eat\n(B)oth Cheese and No Meat\n(N)o Addon\n\nMake a selection: ");
		String addonOption = sc.nextLine();
		addonOption = addonOption.trim().toUpperCase();
		
		if(addonOption.equals("C") || addonOption.startsWith("ADD CHEESE"))
		{
			return FoodAddon.CHEESE;
		}
		else if(addonOption.equals("M") || addonOption.startsWith("NO MEAT"))
		{
			return FoodAddon.NOMEAT;
		}
		else if(addonOption.equals("B") || addonOption.startsWith("BOTH CHEESE AND NO MEAT"))
		{
			return FoodAddon.BOTH;
		}
		else if(addonOption.equals("N") || addonOption.startsWith("NO ADDON"))
		{
			return FoodAddon.NONE;
		}
		return null;
	}
}