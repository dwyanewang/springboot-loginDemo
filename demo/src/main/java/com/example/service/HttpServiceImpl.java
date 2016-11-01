package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.constant.ErrorCodes;
import com.example.entity.account.AccountSummary;
import com.example.exception.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service(HttpService.BEAN_NAME)
public class HttpServiceImpl implements HttpService {
	private static Logger logger = LoggerFactory.getLogger(HttpServiceImpl.class);

	public String httpGet(String urlString) throws ServiceException {
		logger.info("[HTTP][GET] START calling for url:" + urlString);
		Assert.notNull(urlString);

		StringBuilder responseBuilder = new StringBuilder();
		try {
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			HttpURLConnection http = (HttpURLConnection) conn;
			// http.setRequestProperty("Content-type", "application/json");
			http.setRequestMethod("GET");
			http.connect();

			InputStream inputStream = http.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			if (logger.isDebugEnabled()) {
				logger.debug("============ HTTP GET RESPONSE START =================");
			}
			String readLine = null;
			while ((readLine = reader.readLine()) != null) {
				if (logger.isDebugEnabled()) {
					logger.debug(readLine);
				}
				responseBuilder.append(readLine);
			}
			if (logger.isDebugEnabled()) {
				logger.debug("============ HTTP GET RESPONSE END =================");
			}
			reader.close();
			inputStream.close();
			http.disconnect();
			logger.info("[HTTP][GET] END calling for url:" + urlString);
		} catch (MalformedURLException e) {
			logger.error("MalformedURLException occurred - " + e.toString(), e);
			throw new ServiceException(ErrorCodes.SERVICE_ERROR, "MalformedURLException");
		} catch (IOException e) {
			logger.error("IOException occurred - " + e.toString(), e);
			throw new ServiceException(ErrorCodes.SERVICE_ERROR, "Connnection Error, please try again later.");
		}
		return responseBuilder.toString();
	}

	public <T> T httpGet(String urlString, Class<T> T) throws ServiceException {
		String resultString = this.httpGet(urlString);
		ObjectMapper mapper = new ObjectMapper();
		T result = null;
		try {
			result = mapper.readValue(resultString, T);
		} catch (IOException e) {
			logger.error("IOException occurred - " + e.toString(), e);
			throw new ServiceException(ErrorCodes.SERVICE_ERROR, "Connnection Error, please try again later.");
		}
		return result;
	}

	public String httpPost(String urlString, String body) throws ServiceException {
		logger.info("[HTTP][POST] START calling for url:" + urlString);
		Assert.notNull(urlString);

		StringBuilder responseBuilder = new StringBuilder();
		try {
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			HttpURLConnection http = (HttpURLConnection) conn;
			http.setRequestProperty("Content-type", "application/json;charset=UTF-8");
			http.setRequestProperty("Accept", "application/json");

			http.setRequestMethod("POST");
			http.connect();

			if (logger.isDebugEnabled()) {
				logger.debug("============ HTTP POST REQUEST START =================");
				logger.debug(body);
			}
			OutputStream outputStream = http.getOutputStream();
			outputStream.write(body.getBytes(Charset.forName("UTF-8")));
			outputStream.flush();
			outputStream.close();
			if (logger.isDebugEnabled()) {
				logger.debug("============ HTTP POST REQUEST END =================");
			}

			InputStream inputStream = http.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			if (logger.isDebugEnabled()) {
				logger.debug("============ HTTP POST RESPONSE START =================");
			}
			String readLine = null;
			while ((readLine = reader.readLine()) != null) {
				if (logger.isDebugEnabled()) {
					logger.debug(readLine);
				}
				responseBuilder.append(readLine);
			}
			if (logger.isDebugEnabled()) {
				logger.debug("============ HTTP POST RESPONSE END =================");
			}
			reader.close();
			inputStream.close();
			http.disconnect();
			logger.info("[HTTP][POST] END calling for url:" + urlString);
		} catch (MalformedURLException e) {
			logger.error("MalformedURLException occurred - " + e.toString(), e);
			throw new ServiceException(ErrorCodes.SERVICE_ERROR, "MalformedURLException");
		} catch (IOException e) {
			logger.error("IOException occurred - " + e.toString(), e);
			throw new ServiceException(ErrorCodes.SERVICE_ERROR, "Connnection Error, please try again later.");
		}
		return responseBuilder.toString();
	}

	public <T> T httpPost(String urlString, Object request, Class<T> T) throws ServiceException {
		ObjectMapper mapper = new ObjectMapper();
		String requestJson = "";
		try {
			requestJson = mapper.writeValueAsString(request);
		} catch (JsonProcessingException e1) {
			logger.error("JsonProcessingException occurred - " + e1.toString(), e1);
			throw new ServiceException(ErrorCodes.SERVICE_ERROR, "JsonProcessingException");
		}
		String resultString = this.httpPost(urlString, requestJson);

		T result = null;
		try {
			result = mapper.readValue(resultString, T);
		} catch (IOException e) {
			logger.error("IOException occurred - " + e.toString(), e);
			throw new ServiceException(ErrorCodes.SERVICE_ERROR, "Connnection Error, please try again later.");
		}
		return result;
	}
}
