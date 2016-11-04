package com.example.entity.account;

import java.util.Collection;

public class CheckingAccount extends Account {
	private Float annualPercentageYield;
	private Collection<TransactionSummary> checkingAccountTransactions;
	
	public Float getAnnualPercentageYield() {
		return annualPercentageYield;
	}
	public void setAnnualPercentageYield(Float annualPercentageYield) {
		this.annualPercentageYield = annualPercentageYield;
	}
	public Collection<TransactionSummary> getCheckingAccountTransactions() {
		return checkingAccountTransactions;
	}
	public void setCheckingAccountTransactions(Collection<TransactionSummary> checkingAccountTransactions) {
		this.checkingAccountTransactions = checkingAccountTransactions;
	}
}
