package com.example.web.controller;

import static com.example.web.model.common.ResponseCode.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.exception.BusinessException;
import com.example.exception.InputValidationException;
import com.example.exception.ServiceException;
import com.example.web.model.common.ErrorResponse;

@ControllerAdvice
@Order(100)
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler(InputValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleInputValidationException(InputValidationException e){
        if(logger.isDebugEnabled()){
            logger.debug("InputValidationException occurred - " + e.getMessage());
        }
        
        ErrorResponse res = new ErrorResponse();
        res.setObjectErrors(e.getErrors());
        res.setResponseCode(VALIDATE_FAIL);
        return res;
    }
    
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleBusinessException(BusinessException e){
        if(logger.isDebugEnabled()){
            logger.debug("BusinessException occurred - " + e.getMessage());
        }
        
        ErrorResponse res = new ErrorResponse();
        res.setErrors(e.getErrors());
        res.setResponseCode(BUSINESS_ERROR);
        return res;
    }
    
    
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleServiceException(ServiceException e){
        if(logger.isDebugEnabled()){
            logger.debug("ServiceException occurred - " + e.getMessage());
        }
        
        ErrorResponse res = new ErrorResponse();
        res.setErrors(e.getErrors());
        res.setResponseCode(BUSINESS_ERROR);
        return res;
    }
}
