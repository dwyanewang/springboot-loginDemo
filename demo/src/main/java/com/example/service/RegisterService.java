package com.example.service;

import java.io.IOException;
import java.util.Map;

import com.example.entity.User;
import com.example.exception.ServiceException;

public interface RegisterService {
    
    public static final String BEAN_NAME = "registerService";
    
    public User registNew(User regUser) throws ServiceException;

}
