package com.example.entity.account;

import java.util.Collection;

public class SavingsAccountsSummary {
	private Amount savingsAccountsTotalBalanceAmount;
	private Collection<SavingAccount> savingsAccounts;

	public Amount getSavingsAccountsTotalBalanceAmount() {
		return savingsAccountsTotalBalanceAmount;
	}

	public void setSavingsAccountsTotalBalanceAmount(Amount savingsAccountsTotalBalanceAmount) {
		this.savingsAccountsTotalBalanceAmount = savingsAccountsTotalBalanceAmount;
	}

	public Collection<SavingAccount> getSavingsAccounts() {
		return savingsAccounts;
	}

	public void setSavingsAccounts(Collection<SavingAccount> savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}
}
