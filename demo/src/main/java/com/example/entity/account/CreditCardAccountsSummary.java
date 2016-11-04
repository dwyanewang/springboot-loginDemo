package com.example.entity.account;

import java.util.Collection;


public class CreditCardAccountsSummary{
	private Collection<CreditAccount> creditCardAccounts;

	public Collection<CreditAccount> getCreditCardAccounts() {
		return creditCardAccounts;
	}

	public void setCreditCardAccounts(Collection<CreditAccount> creditCardAccounts) {
		this.creditCardAccounts = creditCardAccounts;
	}		
}
