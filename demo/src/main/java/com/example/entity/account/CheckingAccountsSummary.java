package com.example.entity.account;

import java.util.Collection;

public class CheckingAccountsSummary{
	private Amount checkingAccountsTotalBalanceAmount;
	private Collection<CheckingAccount> checkingAccounts;
	public Amount getCheckingAccountsTotalBalanceAmount() {
		return checkingAccountsTotalBalanceAmount;
	}
	public void setCheckingAccountsTotalBalanceAmount(Amount checkingAccountsTotalBalanceAmount) {
		this.checkingAccountsTotalBalanceAmount = checkingAccountsTotalBalanceAmount;
	}
	public Collection<CheckingAccount> getCheckingAccounts() {
		return checkingAccounts;
	}
	public void setCheckingAccounts(Collection<CheckingAccount> checkingAccounts) {
		this.checkingAccounts = checkingAccounts;
	}
}
