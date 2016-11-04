package com.example.entity.account;

public class Fund {
	private Float investmentPercentageRate;
	private String productType;
	private Amount sevenDayYield;
	private Amount thirtyDayYield;
	private Amount totalSecurityValue;

	public Float getInvestmentPercentageRate() {
		return investmentPercentageRate;
	}

	public void setInvestmentPercentageRate(Float investmentPercentageRate) {
		this.investmentPercentageRate = investmentPercentageRate;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Amount getSevenDayYield() {
		return sevenDayYield;
	}

	public void setSevenDayYield(Amount sevenDayYield) {
		this.sevenDayYield = sevenDayYield;
	}

	public Amount getThirtyDayYield() {
		return thirtyDayYield;
	}

	public void setThirtyDayYield(Amount thirtyDayYield) {
		this.thirtyDayYield = thirtyDayYield;
	}

	public Amount getTotalSecurityValue() {
		return totalSecurityValue;
	}

	public void setTotalSecurityValue(Amount totalSecurityValue) {
		this.totalSecurityValue = totalSecurityValue;
	}

}
