package com.example.service;

import com.example.exception.ServiceException;

public interface HttpService {
	
	public static final String BEAN_NAME = "httpService";

	public String httpGet(String urlString) throws ServiceException;
	
	public <T> T httpGet(String urlString, Class<T> T) throws ServiceException;

	public String httpPost(String urlString, String body) throws ServiceException;

	public <T> T httpPost(String urlString, Object request, Class<T> T) throws ServiceException;
	
}
