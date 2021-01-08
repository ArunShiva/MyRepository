package com.tcs.webapp.service.impl;

import org.springframework.stereotype.Service;

import com.tcs.webapp.model.UserDetails;
import com.tcs.webapp.service.IAddUserDetails;

@Service
public class AddUserDetails implements IAddUserDetails {

	@Override
	public UserDetails addUserDetails(UserDetails user) {
		// TODO Auto-generated method stub
		UserDetails user1 = new UserDetails(user.getId(), user.getName(), user.getAddress(), user.getEmailId());
		return user1;
	}

}
