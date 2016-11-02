package com.example.web.model;

public class UserRoleModel {
	private String role;
	private String name;
	private Boolean selected;
	
	public UserRoleModel(){
	}

	public UserRoleModel(String role, String name) {
		this(role, name, true);
	}

	public UserRoleModel(String role, String name, Boolean selected) {
		this.role = role;
		this.name = name;
		this.selected = selected;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

}
