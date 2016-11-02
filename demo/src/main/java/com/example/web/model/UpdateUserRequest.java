package com.example.web.model;

import com.example.web.model.common.JsonRequest;

public class UpdateUserRequest extends JsonRequest {
	
	private UserDetailModel user;
	
	public UpdateUserRequest(){
	}

	public UserDetailModel getUser() {
		return user;
	}

	public void setUser(UserDetailModel user) {
		this.user = user;
	}
}
