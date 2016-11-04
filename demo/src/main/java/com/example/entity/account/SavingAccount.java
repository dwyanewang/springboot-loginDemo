package com.example.entity.account;

import java.util.Collection;

public class SavingAccount extends Account {
	private Float annualPercentageYield;
	private Collection<TransactionSummary> savingsAccountTransactions;

	public Collection<TransactionSummary> getSavingsAccountTransactions() {
		return savingsAccountTransactions;
	}

	public void setSavingsAccountTransactions(Collection<TransactionSummary> savingsAccountTransactions) {
		this.savingsAccountTransactions = savingsAccountTransactions;
	}

	public Float getAnnualPercentageYield() {
		return annualPercentageYield;
	}

	public void setAnnualPercentageYield(Float annualPercentageYield) {
		this.annualPercentageYield = annualPercentageYield;
	}
}
