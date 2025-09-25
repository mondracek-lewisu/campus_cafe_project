package campus_cafe_project.model;

import java.math.BigDecimal;

public enum FoodAddon 
{
	CHEESE(BigDecimal.valueOf(0.5)),
	NOMEAT(BigDecimal.valueOf(-0.5)),
	NONE(BigDecimal.valueOf(0)),
	BOTH(BigDecimal.valueOf(0));

	private final BigDecimal surcharge;
	
	FoodAddon(BigDecimal surcharge)
	{
		this.surcharge = surcharge;
	}
	
	public BigDecimal getSurcharge()
	{
		return surcharge;
	}
}