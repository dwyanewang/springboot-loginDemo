package com.example.web.model.common;

public class ErrorDetail {

    public static final String DEFAULT_CODE = "_ErrorSummary";

    private String code;
    private String field;
    private String message;

    public ErrorDetail() {
    }

    public ErrorDetail(String code, String field, String message) {
        this.code = code;
        this.field = field;
        this.message = message;
    }

    public ErrorDetail(String code, String message) {
        this(code,DEFAULT_CODE,message);
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorDetail [code=" + code + ", field=" + field + ", message=" + message + "]";
    }
}
