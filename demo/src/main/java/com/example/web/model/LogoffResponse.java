package com.example.web.model;

import com.example.web.model.common.JsonResponse;

public class LogoffResponse extends JsonResponse {
    
    public LogoffResponse(String code, String msg){
        this.setResponseCode(code);
        this.setMessage(msg);
    }
}
