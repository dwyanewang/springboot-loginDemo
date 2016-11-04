package com.example.entity.account;

public class Transaction {
	private CurrencyCode transactionCurrencyCode;
	private String checkNumber;
	private String transactionDescription;
	private Amount transactionAmount;
	private String transactionInitiationDate;
	private String transactionDate;
	private String transactionPostingDate;
	private String transactionDescriptionCode;
	private String transactionDescriptionExtension;
	private String achAndDebitCardTransactionIndicator;

	public CurrencyCode getTransactionCurrencyCode() {
		return transactionCurrencyCode;
	}

	public void setTransactionCurrencyCode(CurrencyCode transactionCurrencyCode) {
		this.transactionCurrencyCode = transactionCurrencyCode;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public Amount getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Amount transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionInitiationDate() {
		return transactionInitiationDate;
	}

	public void setTransactionInitiationDate(String transactionInitiationDate) {
		this.transactionInitiationDate = transactionInitiationDate;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionPostingDate() {
		return transactionPostingDate;
	}

	public void setTransactionPostingDate(String transactionPostingDate) {
		this.transactionPostingDate = transactionPostingDate;
	}

	public String getTransactionDescriptionCode() {
		return transactionDescriptionCode;
	}

	public void setTransactionDescriptionCode(String transactionDescriptionCode) {
		this.transactionDescriptionCode = transactionDescriptionCode;
	}

	public String getTransactionDescriptionExtension() {
		return transactionDescriptionExtension;
	}

	public void setTransactionDescriptionExtension(String transactionDescriptionExtension) {
		this.transactionDescriptionExtension = transactionDescriptionExtension;
	}

	public String getAchAndDebitCardTransactionIndicator() {
		return achAndDebitCardTransactionIndicator;
	}

	public void setAchAndDebitCardTransactionIndicator(String achAndDebitCardTransactionIndicator) {
		this.achAndDebitCardTransactionIndicator = achAndDebitCardTransactionIndicator;
	}

}
