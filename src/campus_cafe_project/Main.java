package campus_cafe_project;

import campus_cafe_project.data.*;
import campus_cafe_project.model.*;
import java.util.Scanner;

public class Main 
{
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{	
		
		Menu menu = new Menu();
		String menuOption = "";
		do
		{
			menu.displayMenu();
			System.out.print("\nPlease make selection: ");
			menuOption = sc.nextLine();
			Product item = menu.getMenuItem(menuOption);
			
			if(item == null)
			{
				System.out.println("Your selection is invalid.");
				continue;
			}
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			item.setQuantity(quantity);
			if(item instanceof Beverage)
			{
				BeverageSize beverageSize = getBeverageSize();
				((Beverage) item).setBeverageSize(beverageSize);
				System.out.println(String.format("\nYou selected: %s -- %s -- $%.2f -- %s -- x%d -- total price: $%.2f",
						item.getId(), item.getName(), item.getBasePrice(), ((Beverage)item).getSize(), item.getQuantity(), item.price()));
			}
		}
		while(!menuOption.equals("end"));
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
}