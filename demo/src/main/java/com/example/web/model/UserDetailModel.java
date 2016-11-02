package com.example.web.model;

import java.util.ArrayList;
import java.util.Collection;

import com.example.entity.User;
import com.example.entity.UserAuthority;

public class UserDetailModel{
	private String id;
	private String userName;
	private String email;
	private String status;
	private String signature;
	
	private Collection<UserRoleModel> roles = new ArrayList<UserRoleModel>();
	
	public UserDetailModel(User user, Collection<UserAuthority> authorities){
		this.id = user.getId();
		this.userName = user.getUserName();
		this.email = user.getEmail();
		this.status = user.getStatus();
		this.signature = user.getSignature();
		
		boolean found = false;
		for(UserAuthority authority : authorities){
			found = false;
			for(UserAuthority granted : user.getAuthorities()){
				if(granted.getAuthority().equals(authority.getAuthority())){
					found = true;
					break;
				}
			}
			roles.add(new UserRoleModel(authority.getAuthority(), authority.getDescription(),found));
		}
	}
	
	public UserDetailModel(){
	}
	
	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}
	public String getStatus() {
		return status;
	}
	public Collection<UserRoleModel> getRoles() {
		return roles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRoles(Collection<UserRoleModel> roles) {
		this.roles = roles;
	}



	public String getSignature() {
		return signature;
	}


	public void setSignature(String signature) {
		this.signature = signature;
	}
}
