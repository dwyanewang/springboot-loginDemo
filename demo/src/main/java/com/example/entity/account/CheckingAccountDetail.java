package com.example.entity.account;

public class CheckingAccountDetail {
	private String accountId;
	private Float annualPercentageYield;
	private CurrencyCode currencyCode;
	private Amount availableBalanceAmount;
	private Amount availableCreditAmount;
	private Amount currentBalanceAmount;
	private String balanceAsOfDate;
	private Amount interestPaidYearToDate;
	private Amount interestEarnedLastYear;
	private Float interestRate;
	private String productType;
	private Amount unsweptBalance;
	private Fund sweepFunds;
	private Transaction checkingAccountTransactions;
	
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Float getAnnualPercentageYield() {
		return annualPercentageYield;
	}
	public void setAnnualPercentageYield(Float annualPercentageYield) {
		this.annualPercentageYield = annualPercentageYield;
	}
	public CurrencyCode getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}
	public Amount getAvailableBalanceAmount() {
		return availableBalanceAmount;
	}
	public void setAvailableBalanceAmount(Amount availableBalanceAmount) {
		this.availableBalanceAmount = availableBalanceAmount;
	}
	public Amount getAvailableCreditAmount() {
		return availableCreditAmount;
	}
	public void setAvailableCreditAmount(Amount availableCreditAmount) {
		this.availableCreditAmount = availableCreditAmount;
	}
	public Amount getCurrentBalanceAmount() {
		return currentBalanceAmount;
	}
	public void setCurrentBalanceAmount(Amount currentBalanceAmount) {
		this.currentBalanceAmount = currentBalanceAmount;
	}
	public String getBalanceAsOfDate() {
		return balanceAsOfDate;
	}
	public void setBalanceAsOfDate(String balanceAsOfDate) {
		this.balanceAsOfDate = balanceAsOfDate;
	}
	public Amount getInterestPaidYearToDate() {
		return interestPaidYearToDate;
	}
	public void setInterestPaidYearToDate(Amount interestPaidYearToDate) {
		this.interestPaidYearToDate = interestPaidYearToDate;
	}
	public Amount getInterestEarnedLastYear() {
		return interestEarnedLastYear;
	}
	public void setInterestEarnedLastYear(Amount interestEarnedLastYear) {
		this.interestEarnedLastYear = interestEarnedLastYear;
	}
	public Float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Float interestRate) {
		this.interestRate = interestRate;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Amount getUnsweptBalance() {
		return unsweptBalance;
	}
	public void setUnsweptBalance(Amount unsweptBalance) {
		this.unsweptBalance = unsweptBalance;
	}
	public Fund getSweepFunds() {
		return sweepFunds;
	}
	public void setSweepFunds(Fund sweepFunds) {
		this.sweepFunds = sweepFunds;
	}
	public Transaction getCheckingAccountTransactions() {
		return checkingAccountTransactions;
	}
	public void setCheckingAccountTransactions(Transaction checkingAccountTransactions) {
		this.checkingAccountTransactions = checkingAccountTransactions;
	}
}
