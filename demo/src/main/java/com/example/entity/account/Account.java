package com.example.entity.account;


public class Account {
		private String accountId;
		private String accountDisplayName;
		private String accountFi;
		private String accountNickname;
		private CurrencyCode accountStatus;
		private CurrencyCode currencyCode;
		private Amount currentBalanceAmount;
		
		
		private Amount availableBalanceAmount;
		private String bankingPackage;
		private Boolean billPaymentFlag;
		
		
		private Boolean displayBalancesFlag;
		private Boolean transactionJournalSupportedFlag;
		private Boolean todaysTransactionsOnlyFlag;
		private Amount overdraftLimit;
		private String productType;
		private Integer regulationDTransactionAvailCounter;
		private String statusAsOfDate;
		private String subProductType;
		private Boolean sweepOptionFlag;
		
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
		public String getAccountFi() {
			return accountFi;
		}
		public void setAccountFi(String accountFi) {
			this.accountFi = accountFi;
		}
		public String getAccountNickname() {
			return accountNickname;
		}
		public void setAccountNickname(String accountNickname) {
			this.accountNickname = accountNickname;
		}
		public Amount getAvailableBalanceAmount() {
			return availableBalanceAmount;
		}
		public void setAvailableBalanceAmount(Amount availableBalanceAmount) {
			this.availableBalanceAmount = availableBalanceAmount;
		}
		public String getBankingPackage() {
			return bankingPackage;
		}
		public void setBankingPackage(String bankingPackage) {
			this.bankingPackage = bankingPackage;
		}
		public Boolean getBillPaymentFlag() {
			return billPaymentFlag;
		}
		public void setBillPaymentFlag(Boolean billPaymentFlag) {
			this.billPaymentFlag = billPaymentFlag;
		}
		public CurrencyCode getAccountStatus() {
			return accountStatus;
		}
		public void setAccountStatus(CurrencyCode accountStatus) {
			this.accountStatus = accountStatus;
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
		public Boolean getDisplayBalancesFlag() {
			return displayBalancesFlag;
		}
		public void setDisplayBalancesFlag(Boolean displayBalancesFlag) {
			this.displayBalancesFlag = displayBalancesFlag;
		}
		public Boolean getTransactionJournalSupportedFlag() {
			return transactionJournalSupportedFlag;
		}
		public void setTransactionJournalSupportedFlag(Boolean transactionJournalSupportedFlag) {
			this.transactionJournalSupportedFlag = transactionJournalSupportedFlag;
		}
		public Boolean getTodaysTransactionsOnlyFlag() {
			return todaysTransactionsOnlyFlag;
		}
		public void setTodaysTransactionsOnlyFlag(Boolean todaysTransactionsOnlyFlag) {
			this.todaysTransactionsOnlyFlag = todaysTransactionsOnlyFlag;
		}
		public Amount getOverdraftLimit() {
			return overdraftLimit;
		}
		public void setOverdraftLimit(Amount overdraftLimit) {
			this.overdraftLimit = overdraftLimit;
		}
		public String getProductType() {
			return productType;
		}
		public void setProductType(String productType) {
			this.productType = productType;
		}
		public Integer getRegulationDTransactionAvailCounter() {
			return regulationDTransactionAvailCounter;
		}
		public void setRegulationDTransactionAvailCounter(Integer regulationDTransactionAvailCounter) {
			this.regulationDTransactionAvailCounter = regulationDTransactionAvailCounter;
		}
		public String getStatusAsOfDate() {
			return statusAsOfDate;
		}
		public void setStatusAsOfDate(String statusAsOfDate) {
			this.statusAsOfDate = statusAsOfDate;
		}
		public String getSubProductType() {
			return subProductType;
		}
		public void setSubProductType(String subProductType) {
			this.subProductType = subProductType;
		}
		public Boolean getSweepOptionFlag() {
			return sweepOptionFlag;
		}
		public void setSweepOptionFlag(Boolean sweepOptionFlag) {
			this.sweepOptionFlag = sweepOptionFlag;
		}	
}
