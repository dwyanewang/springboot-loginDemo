package com.example.web.controller;

import static com.example.web.model.common.ResponseCode.AUTH_FAIL;
import static com.example.web.model.common.ResponseCode.SUCCESS;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserToken;
import com.example.exception.BusinessException;
import com.example.exception.InputValidationException;
import com.example.service.LoginService;
import com.example.web.model.LoginRequest;
import com.example.web.model.LoginResponse;
import com.example.web.model.LogoffResponse;
import com.example.web.model.common.ErrorDetail;
import com.example.web.model.common.ErrorResponse;
import com.example.web.validator.LoginRequestValidator;

@RestController
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.setValidator(new LoginRequestValidator());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    @CrossOrigin(origins = "*")
    @ResponseBody
    public LoginResponse loginAction(@RequestBody @Valid LoginRequest req, BindingResult result) {
        if (result.hasErrors()) {
            throw new InputValidationException(result.getAllErrors());
        }

        logger.info("loginAction -- new login request for user - " + req.getLoginName());

        UserToken token = loginService.authentication(req.getLoginName(), req.getPassword());
        LoginResponse res = null;
        if (token != null) {
            res = new LoginResponse(req.getLoginName(), token, token.getAuthorities());
            res.setResponseCode(SUCCESS);
            res.setMessage("Login success for  " + req.getLoginName());
        } else {
            ErrorDetail error = new ErrorDetail();
            error.setCode("LoginFail");
            error.setField(ErrorDetail.DEFAULT_CODE);
            error.setMessage("Login fail, please check id & password and retry");
            throw new BusinessException(error);
        }
        return res;
    }

    @RequestMapping(value = "/logoff", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @CrossOrigin(origins = "*")
    public @ResponseBody LogoffResponse logoffAction() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserToken token = (UserToken) authentication.getPrincipal();
        loginService.logoff(token.getId());
        LogoffResponse res = new LogoffResponse(SUCCESS, "logoffSuccess");
        return res;
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleBusinessError(BusinessException e) {
        ErrorResponse res = new ErrorResponse();
        res.setErrors(e.getErrors());
        res.setResponseCode(AUTH_FAIL);
        return res;
    }

}
