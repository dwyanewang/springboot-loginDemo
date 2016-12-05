package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.account.AccountSummary;
import com.example.entity.account.CheckingAccountDetail;
import com.example.entity.account.CreditAccountDetail;
import com.example.entity.account.SavingAccountDetail;
import com.example.exception.ServiceException;

@Service
public class AccountService {
	
	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	private HttpService httpService;
	
	
	public AccountSummary getAccountSummary() throws ServiceException{
		AccountSummary result = null;
		String URL = "http://vm-0c25-e3ff.nam.nsroot.net:8088/REST/Account";
		
		if (logger.isDebugEnabled()) {
			logger.debug("============ getAccountSummary =================");
		}
		result = httpService.httpGet(URL, AccountSummary.class);
		
		return result;
	}
	
	public CheckingAccountDetail getCheckingAccountDetail() throws ServiceException{
		CheckingAccountDetail result = null;
		String URL = "http://vm-0c25-e3ff.nam.nsroot.net:8088/REST/AccountDetails/1";
		
		if (logger.isDebugEnabled()) {
			logger.debug("============ getCheckingAccountDetail =================");
		}
		result = httpService.httpGet(URL, CheckingAccountDetail.class);
		
		return result;
	}
	
	
	public SavingAccountDetail getSavingAccountDetail() throws ServiceException{
		SavingAccountDetail result = null;
		String URL = "http://vm-0c25-e3ff.nam.nsroot.net:8088/REST/AccountDetails/2";
		
		if (logger.isDebugEnabled()) {
			logger.debug("============ getSavingAccountDetail =================");
		}
		result = httpService.httpGet(URL, SavingAccountDetail.class);
		
		return result;
	}
	
	public CreditAccountDetail getCreditAccountDetail() throws ServiceException{
		CreditAccountDetail result = null;
		String URL = "http://vm-0c25-e3ff.nam.nsroot.net:8088/REST/AccountDetails/3";
		
		if (logger.isDebugEnabled()) {
			logger.debug("============ getCreditAccountDetail =================");
		}
		result = httpService.httpGet(URL, CreditAccountDetail.class);
		
		return result;
	}
	
}
