package campus_cafe_project.model;

import java.math.BigDecimal;

public enum BeverageSize 
{
	SMALL(BigDecimal.valueOf(0)),
	MEDIUM(BigDecimal.valueOf(0.5)),
	LARGE(BigDecimal.valueOf(1));
	
	private final BigDecimal surcharge;
	
	BeverageSize(BigDecimal surcharge)
	{
		this.surcharge = surcharge;
	}
	
	public BigDecimal getSurcharge()
	{
		return surcharge;
	}
}