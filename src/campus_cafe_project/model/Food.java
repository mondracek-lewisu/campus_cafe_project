package campus_cafe_project.model;

import java.math.BigDecimal;

public class Food extends Product
{
	private FoodAddon foodAddon;
	
	public Food(String id, String name, BigDecimal basePrice) 
	{
		super(id, name, basePrice); 	
	}	

	public void setFoodAddon(FoodAddon foodAddon)
	{
		this.foodAddon = foodAddon;
	}
	
	public String getModifier()
	{
		if(foodAddon == FoodAddon.CHEESE)
		{
			return "Add Cheese";
		}
		else if(foodAddon == FoodAddon.NOMEAT)
		{
			return "No Meat";
		}
		else if(foodAddon == FoodAddon.BOTH)
		{
			return "Add Cheese + No Meat";
		}
		else if(foodAddon == FoodAddon.NONE)
		{
			return "No Change";
		}
		return null;
	}
	
	public String getModifierExtra()
	{
		if(foodAddon == FoodAddon.CHEESE)
		{
			return "Add Cheese: +$0.50";
		}
		else if(foodAddon == FoodAddon.NOMEAT)
		{
			return "No Meat: -$0.50";
		}
		else if(foodAddon == FoodAddon.BOTH)
		{
			return "Add Cheese + No Meat: +$0.00";
		}
		else if(foodAddon == FoodAddon.NONE)
		{
			return "No Change: +$0.00";
		}
		return null;
	}
	
	public BigDecimal price() 
	{
		BigDecimal price = this.getBasePrice().add(foodAddon.getSurcharge());
		return price.multiply(BigDecimal.valueOf(this.getQuantity()));
	}
}