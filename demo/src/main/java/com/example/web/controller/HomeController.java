package com.example.web.controller;

import static com.example.web.model.common.ResponseCode.BUSINESS_ERROR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.account.AccountSummary;
import com.example.entity.account.CheckingAccountDetail;
import com.example.entity.account.CreditAccountDetail;
import com.example.entity.account.SavingAccountDetail;
import com.example.exception.BusinessException;
import com.example.exception.ServiceException;
import com.example.service.AccountService;
import com.example.web.model.common.ErrorResponse;

@RestController
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/account", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @CrossOrigin(origins = "*")
    public @ResponseBody AccountSummary accountSummary() throws ServiceException {
    	return accountService.getAccountSummary();
    }
    
    @RequestMapping(value = "/account/checkingAccount", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @CrossOrigin(origins = "*")
    public @ResponseBody CheckingAccountDetail checkingAccount() throws ServiceException {
    	return accountService.getCheckingAccountDetail();
    }
    
    @RequestMapping(value = "/account/savingAccount", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @CrossOrigin(origins = "*")
    public @ResponseBody SavingAccountDetail savingAccount() throws ServiceException {
    	return accountService.getSavingAccountDetail();
    }
    
    @RequestMapping(value = "/account/creditAccountDetail", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @CrossOrigin(origins = "*")
    public @ResponseBody CreditAccountDetail creditAccount() throws ServiceException {
    	return accountService.getCreditAccountDetail();
    }
    
    
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleBusinessError(BusinessException e) {
        ErrorResponse res = new ErrorResponse();
        res.setErrors(e.getErrors());
        res.setResponseCode(BUSINESS_ERROR);
        return res;
    }

}
