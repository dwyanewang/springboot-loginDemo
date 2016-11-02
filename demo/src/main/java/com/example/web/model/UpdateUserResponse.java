package com.example.web.model;

import com.example.web.model.common.JsonResponse;

public class UpdateUserResponse extends JsonResponse {
    
    public UpdateUserResponse(String code, String msg){
        this.setResponseCode(code);
        this.setMessage(msg);
    }
}
