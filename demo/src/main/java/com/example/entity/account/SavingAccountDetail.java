package com.example.entity.account;

import java.util.Collection;

public class SavingAccountDetail {
	private String accountId;
	private Amount annualPercentageYield;
	private CurrencyCode currencyCode;
	private Amount currentBalanceAmount;
	private Amount availableBalanceAmount;
	private Float interestRate;
	private Amount interestAmountEarnedLastYear;
	private Amount interestPaidYearToDate;
	private String productType;
	private Amount principalAmount;
	private Amount maturityValue;
	private Amount interestValueAtMaturity;
	private String maturityDate;
	private Integer productTerm;
	private CurrencyCode periodCode;
	private CurrencyCode interestPaymentCycle;
	
	private Collection<Transaction> savingsAccountTransactions;
	
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Amount getAnnualPercentageYield() {
		return annualPercentageYield;
	}
	public void setAnnualPercentageYield(Amount annualPercentageYield) {
		this.annualPercentageYield = annualPercentageYield;
	}
	public CurrencyCode getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}
	public Amount getCurrentBalanceAmount() {
		return currentBalanceAmount;
	}
	public void setCurrentBalanceAmount(Amount currentBalanceAmount) {
		this.currentBalanceAmount = currentBalanceAmount;
	}
	public Amount getAvailableBalanceAmount() {
		return availableBalanceAmount;
	}
	public void setAvailableBalanceAmount(Amount availableBalanceAmount) {
		this.availableBalanceAmount = availableBalanceAmount;
	}
	public Float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Float interestRate) {
		this.interestRate = interestRate;
	}

	public Amount getInterestPaidYearToDate() {
		return interestPaidYearToDate;
	}
	public void setInterestPaidYearToDate(Amount interestPaidYearToDate) {
		this.interestPaidYearToDate = interestPaidYearToDate;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Amount getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(Amount principalAmount) {
		this.principalAmount = principalAmount;
	}
	public Amount getMaturityValue() {
		return maturityValue;
	}
	public void setMaturityValue(Amount maturityValue) {
		this.maturityValue = maturityValue;
	}
	public Amount getInterestValueAtMaturity() {
		return interestValueAtMaturity;
	}
	public void setInterestValueAtMaturity(Amount interestValueAtMaturity) {
		this.interestValueAtMaturity = interestValueAtMaturity;
	}
	public String getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Integer getProductTerm() {
		return productTerm;
	}
	public void setProductTerm(Integer productTerm) {
		this.productTerm = productTerm;
	}
	public CurrencyCode getPeriodCode() {
		return periodCode;
	}
	public void setPeriodCode(CurrencyCode periodCode) {
		this.periodCode = periodCode;
	}
	public CurrencyCode getInterestPaymentCycle() {
		return interestPaymentCycle;
	}
	public void setInterestPaymentCycle(CurrencyCode interestPaymentCycle) {
		this.interestPaymentCycle = interestPaymentCycle;
	}
	public Amount getInterestAmountEarnedLastYear() {
		return interestAmountEarnedLastYear;
	}
	public void setInterestAmountEarnedLastYear(Amount interestAmountEarnedLastYear) {
		this.interestAmountEarnedLastYear = interestAmountEarnedLastYear;
	}
	public Collection<Transaction> getSavingsAccountTransactions() {
		return savingsAccountTransactions;
	}
	public void setSavingsAccountTransactions(Collection<Transaction> savingsAccountTransactions) {
		this.savingsAccountTransactions = savingsAccountTransactions;
	}
}
