package com.tcs.webapp.service.impl;

import org.springframework.stereotype.Service;

import com.tcs.webapp.model.UserDetails;
import com.tcs.webapp.service.IAddUserDetails;

@Service
public class AddUserDetails implements IAddUserDetails {

	@Override
	public UserDetails addUserDetails(String id,String name, String address, String emailId) {
		// TODO Auto-generated method stub
		UserDetails user1 = new UserDetails(id,name,address,emailId);
		return user1;
	}

}
