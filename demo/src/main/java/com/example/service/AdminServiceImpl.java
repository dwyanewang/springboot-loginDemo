package com.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.constant.ErrorCodes;
import com.example.dao.AuthorityDao;
import com.example.dao.UserDao;
import com.example.entity.Authority;
import com.example.entity.User;
import com.example.entity.UserAuthority;
import com.example.exception.ServiceException;
import com.example.util.DateUtil;
import com.example.web.model.UserDetailModel;
import com.example.web.model.UserRoleModel;

@Service(AdminService.BEAN_NAME)
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private AuthorityDao authorityDao;

	@Override
	public List<User> listAllUser() {
		List<User> users = userDao.findAll();
		List<User> newUsers = new ArrayList<User>();

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);

			if (user.getStatus().equals("A")) {
				user.setStatus("Active");
			} else if (user.getStatus().equals("N")) {
				user.setStatus("Not Active");
			}

			user.setSignature(DateUtil.timestampToString(user.getCreateDate()));

			if (user.getRole().equals("U")) {
				user.setRole("User");
			} else if (user.getRole().equals("A")) {
				user = null;
			}
			
			if(user!=null){
				newUsers.add(user);
			}
		}

		return newUsers;
	}

	@Override
	public User getUserById(String uid) {
		return userDao.findById(uid);
	}
	
	@Override
	public Collection<UserAuthority> getAllAuthority(){
		return authorityDao.findAll();
	}

	@Override
	 public void updateUser(String id, UserDetailModel userDetail) throws ServiceException {
		Assert.notNull(id, "ID cannot be empty.");
		Assert.notNull(userDetail, "userDetail cannot be empty.");
		
		User user = userDao.findById(id);
		if(user == null){
			throw new ServiceException(ErrorCodes.SERVICE_ERROR,"user is not found!");
		}
		
		user.setEmail(userDetail.getEmail());
		user.setStatus(userDetail.getStatus());
		user.setSignature(userDetail.getSignature());
		
		user.setAuthorities(new LinkedHashSet<UserAuthority>());
		for(UserRoleModel role: userDetail.getRoles()){
			if(role.getSelected()){
				UserAuthority authority = authorityDao.findByAuthority(role.getRole());
				user.getAuthorities().add(authority);
			}
		}
		
		userDao.save(user);
	}
}
