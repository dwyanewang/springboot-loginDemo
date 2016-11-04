package com.example.entity.account;

public class AccountSummaryDetail {
	private CheckingAccountsSummary checkingAccountsSummary;
	private SavingsAccountsSummary savingsAccountsSummary;
	private CreditCardAccountsSummary creditCardAccountsSummary;

	public CheckingAccountsSummary getCheckingAccountsSummary() {
		return checkingAccountsSummary;
	}

	public void setCheckingAccountsSummary(CheckingAccountsSummary checkingAccountsSummary) {
		this.checkingAccountsSummary = checkingAccountsSummary;
	}

	public SavingsAccountsSummary getSavingsAccountsSummary() {
		return savingsAccountsSummary;
	}

	public void setSavingsAccountsSummary(SavingsAccountsSummary savingsAccountsSummary) {
		this.savingsAccountsSummary = savingsAccountsSummary;
	}

	public CreditCardAccountsSummary getCreditCardAccountsSummary() {
		return creditCardAccountsSummary;
	}

	public void setCreditCardAccountsSummary(CreditCardAccountsSummary creditCardAccountsSummary) {
		this.creditCardAccountsSummary = creditCardAccountsSummary;
	}

}
