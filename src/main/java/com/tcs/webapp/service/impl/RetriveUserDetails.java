package com.tcs.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.webapp.model.UserDetails;
import com.tcs.webapp.service.IRetriveUserDetails;

@Service
public class RetriveUserDetails implements IRetriveUserDetails {

	@Override
	public List<UserDetails> retriveUserDetails() {

		List<UserDetails> userList= new ArrayList<UserDetails>();
		
		UserDetails user1 = new UserDetails("1", "Sam", "Chennai", "sam@gmail.com");
		UserDetails user2 = new UserDetails("2", "Tom", "Kochi", "tom@gmail.com");
		UserDetails user3 = new UserDetails("3", "John", "Coimbatore", "john@gmail.com");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		return userList;
	}

}
