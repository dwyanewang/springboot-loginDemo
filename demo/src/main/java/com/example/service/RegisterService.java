package com.example.service;

import java.io.IOException;
import java.util.Map;

import com.example.entity.User;
import com.example.exception.ServiceException;

public interface RegisterService {
    
    public static final String BEAN_NAME = "registerService";
    

    public Map<String,Object> regist(User user, String soeid) throws IOException;
	
	
    public User registNew(User regUser) throws ServiceException;

}
