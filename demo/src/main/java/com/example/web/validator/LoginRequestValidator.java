package com.example.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.web.model.LoginRequest;

public class LoginRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "loginName", "LoginNameEmpty", "Login ID is empty.");
        ValidationUtils.rejectIfEmpty(errors, "password", "PasswordEmpty", "Password is empty.");
    }
}
