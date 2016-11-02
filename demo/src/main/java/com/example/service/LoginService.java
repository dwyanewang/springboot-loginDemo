package com.example.service;

import com.example.entity.UserToken;

public interface LoginService {
    
    public static final String BEAN_NAME = "loginService";
    
    public UserToken authentication(String userName, String password);
    
    public void logoff(String tokenId);
    
}
