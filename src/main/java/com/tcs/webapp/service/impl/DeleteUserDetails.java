package com.tcs.webapp.service.impl;

import org.springframework.stereotype.Service;

import com.tcs.webapp.model.UserDetails;
import com.tcs.webapp.service.IDeleteUserDetails;

@Service
public class DeleteUserDetails implements IDeleteUserDetails {

	@Override
	public UserDetails deleteUserDetailsByID(String userId) {
		UserDetails user1 = new UserDetails(userId, "Arun", "Chennai", "arun@gmail.com");
		return user1;
	}

}
