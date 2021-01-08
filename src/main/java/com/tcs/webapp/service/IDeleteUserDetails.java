package com.tcs.webapp.service;

import com.tcs.webapp.model.UserDetails;

public interface IDeleteUserDetails {

	public UserDetails deleteUserDetailsByID(String userId);
}
