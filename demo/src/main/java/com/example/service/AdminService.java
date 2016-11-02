package com.example.service;

import java.util.Collection;
import java.util.List;

import com.example.entity.User;
import com.example.entity.UserAuthority;
import com.example.exception.ServiceException;
import com.example.web.model.UserDetailModel;

public interface AdminService {
	 public static final String BEAN_NAME = "adminService";
	 
	 public List<User> listAllUser();
	 
	 public User getUserById(String uid);
	 
	 public void updateUser(String id,UserDetailModel userDetail) throws ServiceException;
	 
	 public Collection<UserAuthority> getAllAuthority();
}
