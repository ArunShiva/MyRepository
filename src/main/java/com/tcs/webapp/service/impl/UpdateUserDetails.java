package com.tcs.webapp.service.impl;

import com.tcs.webapp.model.UserDetails;
import com.tcs.webapp.service.IUpdateUserDetails;

public class UpdateUserDetails implements IUpdateUserDetails {

	@Override
	public UserDetails updateUserDetailsByID(String userId) {
		UserDetails user1 = new UserDetails(userId, "Arun", "Chennai", "arun@gmail.com");
		return user1;
	}

}
