package com.example.entity.account;

public class Amount {
	private Float amount;
	
	private CurrencyCode currencyCode = new CurrencyCode();

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public CurrencyCode getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	
}
class CurrencyCode {
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
