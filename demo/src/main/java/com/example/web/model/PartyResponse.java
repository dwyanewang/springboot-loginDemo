package com.example.web.model;

import com.example.web.model.common.JsonResponse;

public class PartyResponse extends JsonResponse {
    
    public PartyResponse(String code, String msg){
        this.setResponseCode(code);
        this.setMessage(msg);
    }
}
