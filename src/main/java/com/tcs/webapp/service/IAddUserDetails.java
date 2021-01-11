package com.tcs.webapp.service;

import com.tcs.webapp.model.UserDetails;

public interface IAddUserDetails {

	public UserDetails addUserDetails(String id,String name, String address, String emailId);
}
