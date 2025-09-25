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
		String menuOption = "";
		System.out.println("\nWelcome to the Campus Cafe\n");
		
		do
		{
			menu.displayMenu();
			System.out.print("\nPlease make a selection (or type 'end' to finish): ");
			menuOption = sc.nextLine();
			
			if(menuOption.trim().equalsIgnoreCase("end"))
			{
				break;
			}
			
			Product item = menu.getMenuItem(menuOption);
			
			if(item == null)
			{
				System.out.println("Your selection is invalid.");
				continue;
			}
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			while(quantity<=0)
			{
				System.out.println("Invalid Quantity");
				System.out.print("Quantity: ");
				quantity = sc.nextInt();
			}
			sc.nextLine();
			item.setQuantity(quantity);
			
			if(item instanceof Beverage)
			{
				BeverageSize beverageSize = getBeverageSize();
				while(beverageSize == null)
				{
					System.out.println("Invalid Entry");
					beverageSize = getBeverageSize();
				}
				((Beverage) item).setBeverageSize(beverageSize);
			}
			if(item instanceof Food)
			{
				FoodAddon foodAddon = getFoodAddon();
				while(foodAddon == null)
				{
					System.out.println("Invalid Entry");
					foodAddon = getFoodAddon();
				}
				((Food) item).setFoodAddon(foodAddon);
			}
			System.out.println(String.format("\nYou selected: %s -- %s -- $%.2f -- %s -- x%d -- total price: $%.2f\n",
					item.getId(), item.getName(), item.getBasePrice(), item.getModifierExtra(), item.getQuantity(), item.price()));
			order.addLineItem(item);
		}
		
		while(!menuOption.equals("end"));
		order.printReceipt();
	}
	
	private static BeverageSize getBeverageSize()
	{
		System.out.print("Please Select (S)mall, (M)eduim, or (L)arge): ");
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
		System.out.println("Please select one of the following addons:\nAdd (C)heese\nNo (M)eat\n(B)oth Cheese and No Meat\n(N)o Addon");
		String addonOption = sc.nextLine();
		addonOption = addonOption.trim().toUpperCase();
		if(addonOption.equals("C") || addonOption.startsWith("ADD CHEESE"))
		{
			return FoodAddon.CHEESE;
		}
		if(addonOption.equals("M") || addonOption.startsWith("NO MEAT"))
		{
			return FoodAddon.NOMEAT;
		}
		if(addonOption.equals("B") || addonOption.startsWith("BOTH CHEESE AND NO MEAT"))
		{
			return FoodAddon.BOTH;
		}
		if(addonOption.equals("N") || addonOption.startsWith("NO ADDON"))
		{
			return FoodAddon.NONE;
		}
		return null;
	}
}