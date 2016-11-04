package com.example.entity.account;

import java.util.Collection;

public class CreditAccount {
	
	private String accountId;
	private String accountDisplayName;
	private String accountNickname;
	private CurrencyCode accountStatus;
	private Amount availableCreditLine;
	private CurrencyCode currencyCode;
	private Amount currentBalanceAmount;
	private Amount lastStatementBalanceAmount;
	private String lastStatementDate;
	private Amount minimumAmountDue;
	private String paymentDueDate;
	private Amount pastDueAmount;
	private Amount amountOverCreditLine;
	private String numberOfDaysPastDue;
	private Amount lastPaymentAmount;
	private Amount totalCreditLimit;
	private String lastPaymentDate;
	private Amount cashAdvanceAmount;
	private String creditCardApr;
	
	private Collection<TransactionSummary> creditCardAccountTransactions;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountDisplayName() {
		return accountDisplayName;
	}

	public void setAccountDisplayName(String accountDisplayName) {
		this.accountDisplayName = accountDisplayName;
	}

	public String getAccountNickname() {
		return accountNickname;
	}

	public void setAccountNickname(String accountNickname) {
		this.accountNickname = accountNickname;
	}

	public CurrencyCode getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(CurrencyCode accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Amount getAvailableCreditLine() {
		return availableCreditLine;
	}

	public void setAvailableCreditLine(Amount availableCreditLine) {
		this.availableCreditLine = availableCreditLine;
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

	public Amount getLastStatementBalanceAmount() {
		return lastStatementBalanceAmount;
	}

	public void setLastStatementBalanceAmount(Amount lastStatementBalanceAmount) {
		this.lastStatementBalanceAmount = lastStatementBalanceAmount;
	}

	public String getLastStatementDate() {
		return lastStatementDate;
	}

	public void setLastStatementDate(String lastStatementDate) {
		this.lastStatementDate = lastStatementDate;
	}

	public Amount getMinimumAmountDue() {
		return minimumAmountDue;
	}

	public void setMinimumAmountDue(Amount minimumAmountDue) {
		this.minimumAmountDue = minimumAmountDue;
	}

	public String getPaymentDueDate() {
		return paymentDueDate;
	}

	public void setPaymentDueDate(String paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	public Amount getPastDueAmount() {
		return pastDueAmount;
	}

	public void setPastDueAmount(Amount pastDueAmount) {
		this.pastDueAmount = pastDueAmount;
	}

	public Amount getAmountOverCreditLine() {
		return amountOverCreditLine;
	}

	public void setAmountOverCreditLine(Amount amountOverCreditLine) {
		this.amountOverCreditLine = amountOverCreditLine;
	}

	public String getNumberOfDaysPastDue() {
		return numberOfDaysPastDue;
	}

	public void setNumberOfDaysPastDue(String numberOfDaysPastDue) {
		this.numberOfDaysPastDue = numberOfDaysPastDue;
	}

	public Amount getLastPaymentAmount() {
		return lastPaymentAmount;
	}

	public void setLastPaymentAmount(Amount lastPaymentAmount) {
		this.lastPaymentAmount = lastPaymentAmount;
	}

	public Amount getTotalCreditLimit() {
		return totalCreditLimit;
	}

	public void setTotalCreditLimit(Amount totalCreditLimit) {
		this.totalCreditLimit = totalCreditLimit;
	}

	public String getLastPaymentDate() {
		return lastPaymentDate;
	}

	public void setLastPaymentDate(String lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}

	public Amount getCashAdvanceAmount() {
		return cashAdvanceAmount;
	}

	public void setCashAdvanceAmount(Amount cashAdvanceAmount) {
		this.cashAdvanceAmount = cashAdvanceAmount;
	}

	public String getCreditCardApr() {
		return creditCardApr;
	}

	public void setCreditCardApr(String creditCardApr) {
		this.creditCardApr = creditCardApr;
	}

	public Collection<TransactionSummary> getCreditCardAccountTransactions() {
		return creditCardAccountTransactions;
	}

	public void setCreditCardAccountTransactions(Collection<TransactionSummary> creditCardAccountTransactions) {
		this.creditCardAccountTransactions = creditCardAccountTransactions;
	}		
}
