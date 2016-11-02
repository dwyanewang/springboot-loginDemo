package com.example.web.model;

import java.util.Collection;

import com.example.entity.User;
import com.example.entity.UserAuthority;
import com.example.web.model.common.JsonResponse;

public class UserDetailResponse extends JsonResponse {
	private UserDetailModel user;
	
	public UserDetailResponse(User user, Collection<UserAuthority> authorities){
		this.user = new UserDetailModel(user, authorities);
	}

	public UserDetailModel getUser() {
		return user;
	}

	public void setUser(UserDetailModel user) {
		this.user = user;
	}
}


