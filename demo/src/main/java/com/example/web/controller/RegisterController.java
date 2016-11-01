package com.example.web.controller;

import static com.example.web.model.common.ResponseCode.SUCCESS;

import java.io.IOException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.ErrorCodes;
import com.example.entity.User;
import com.example.entity.UserToken;
import com.example.exception.BusinessException;
import com.example.exception.InputValidationException;
import com.example.exception.ServiceException;
import com.example.service.LoginServiceImpl;
import com.example.service.RegisterService;
import com.example.util.CheckPwdStrengthUtil;
import com.example.web.model.LoginResponse;
import com.example.web.model.RegisterRequest;
import com.example.web.model.common.ErrorDetail;
import com.example.web.validator.RegisterRequestValidator;

@RestController
public class RegisterController {
	private static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private LoginServiceImpl loginService;

	@Autowired
	private RegisterService registerService;

	@InitBinder
	public void initBinder(DataBinder binder) {
		binder.setValidator(new RegisterRequestValidator());
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@CrossOrigin(origins = "*")
	@ResponseBody
	public LoginResponse registAction(@RequestBody @Valid RegisterRequest req, BindingResult result)
			throws ServiceException {
		if (result.hasErrors()) {
			throw new InputValidationException(result.getAllErrors());
		}

		logger.info("registAction -- new regist request for user - " + req.getUserName());

		User regUser = new User(req.getUserName(), req.getPassword(), req.getEmail(), req.getGender(),
				req.getSignature());

		User user = registerService.registNew(regUser);
		if (user == null) {
			throw new BusinessException(new ErrorDetail(ErrorCodes.FAIL, "Register is fail, please try again later."));
		}

		logger.info("loginAction -- new login request for user - " + req.getUserName());

		UserToken token = loginService.authentication(req.getUserName(), req.getPassword());
		LoginResponse res = null;
		if (token != null) {
			res = new LoginResponse(req.getUserName(), token, token.getAuthorities());
			res.setResponseCode(SUCCESS);
			res.setMessage("Login success for  " + req.getUserName());
		} else {
			ErrorDetail error = new ErrorDetail();
			error.setCode("LoginFail");
			error.setField(ErrorDetail.DEFAULT_CODE);
			error.setMessage("Login fail, please check id & password and retry");
			throw new BusinessException(error);
		}
		return res;
	}

	@RequestMapping("/validPwd")
	@CrossOrigin(origins = "*")
	@ResponseBody
	public int validPwdAction(@Param("pass") String pass) throws IOException {

		return CheckPwdStrengthUtil.check(pass);// valid password strength,
												// return the strength code
	}
}
