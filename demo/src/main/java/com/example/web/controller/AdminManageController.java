package com.example.web.controller;

import static com.example.web.model.common.ResponseCode.SUCCESS;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.entity.UserAuthority;
import com.example.exception.InputValidationException;
import com.example.exception.ServiceException;
import com.example.service.AdminService;
import com.example.web.model.UpdateUserRequest;
import com.example.web.model.UpdateUserResponse;
import com.example.web.model.UserDetailModel;
import com.example.web.model.UserDetailResponse;
import com.example.web.validator.UpdateUserRequestValidator;

@RestController
public class AdminManageController {
	private static Logger logger = LoggerFactory.getLogger(AdminManageController.class);
	
	@Autowired
	private AdminService adminService;
	
    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.setValidator(new UpdateUserRequestValidator());
    }

	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	@ResponseBody
	public List<User> listUser() {
		logger.info("AdminManageController -- all User List" + adminService.listAllUser());
		return adminService.listAllUser();
	}

	@RequestMapping(value = "/admin/user/{uid}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	@ResponseBody
	public UserDetailResponse userDetail(@PathVariable String uid) {
		User user = adminService.getUserById(uid);
		Collection<UserAuthority> allAuthorities = adminService.getAllAuthority();
		UserDetailResponse res =  new UserDetailResponse(user,allAuthorities);
		res.setResponseCode(SUCCESS);
		return res;
	}

	@RequestMapping(value = "/admin/user/{uid}", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@CrossOrigin(origins = "*")
	@ResponseBody
	public UpdateUserResponse userUpdate(@PathVariable String uid, @RequestBody @Valid UpdateUserRequest req, BindingResult result) throws ServiceException {
        if (result.hasErrors()) {
            throw new InputValidationException(result.getAllErrors());
        }
		
		UserDetailModel userDetail = req.getUser();
		String id = uid;
		
		adminService.updateUser(id,userDetail);

		logger.info("userUpdate -- update success for [" + id +"][" + userDetail.getUserName() + "]");
		UpdateUserResponse res = new UpdateUserResponse(SUCCESS, "Update Success");
		return res;

	}
}
