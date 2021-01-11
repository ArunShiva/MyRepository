package com.tcs.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.webapp.constants.GeneralConstants;
import com.tcs.webapp.dto.BaseResponse;
import com.tcs.webapp.model.UserDetails;
import com.tcs.webapp.service.IAddUserDetails;
import com.tcs.webapp.service.IDeleteUserDetails;
import com.tcs.webapp.service.IRetriveUserDetails;
import com.tcs.webapp.service.IUpdateUserDetails;
import com.tcs.webapp.utils.GeneralUtil;


@RestController
@RequestMapping("/services")
public class WebAppController extends BaseResponse{

	@Autowired
	IRetriveUserDetails retriveUserDetails;
	
	@Autowired
	IUpdateUserDetails updateUserDetails;
	
	@Autowired
	IAddUserDetails addUserDetails;
	
	@Autowired
	IDeleteUserDetails deleteUserDetails;

	@CrossOrigin
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/getAllUserList", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public BaseResponse getAllUserList() {
		
		System.out.println("GetAllUserList Contoller called");

		BaseResponse response = new BaseResponse();
		List<UserDetails> userList = retriveUserDetails.retriveUserDetails();
		
		if(GeneralUtil.getInstance().isNotEmptyArrayList(userList)) {
			response.setStatus(GeneralConstants.SUCCESS_STATUS);
			response.setData(userList);
			
		}else {
			response.setStatus(GeneralConstants.ERROR_STATUS);
			response.setErrorMesage(GeneralConstants.ERROR_MESSAGE);
			response.setData(null);
		}
		
		return response;

	}
	
	@CrossOrigin
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/updateUserDetails", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public BaseResponse updateUserDetails(@RequestBody String userId) {
		
		System.out.println("UpdateUserList Contoller called");

		BaseResponse response = new BaseResponse();
		UserDetails user = updateUserDetails.updateUserDetailsByID(userId);
		
		if(GeneralUtil.getInstance().isNotEmptyObject(user)) {
			response.setStatus(GeneralConstants.SUCCESS_STATUS);
			response.setData("User Updated Successfully");
			
		}else {
			response.setStatus(GeneralConstants.ERROR_STATUS);
			response.setErrorMesage(GeneralConstants.ERROR_MESSAGE);
			response.setData(null);
		}
		
		return response;

	}
	
	@CrossOrigin
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/addUserDetails", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public BaseResponse addUserDetails(@RequestBody String id,String name, String address, String emailId) {
		
		System.out.println("AddUserDetails Contoller called");

		BaseResponse response = new BaseResponse();
		UserDetails user1 = addUserDetails.addUserDetails(id,name,address,emailId);
		
		if(GeneralUtil.getInstance().isNotEmptyObject(user1)) {
			response.setStatus(GeneralConstants.SUCCESS_STATUS);
			response.setData("User Added Successfully");
			
		}else {
			response.setStatus(GeneralConstants.ERROR_STATUS);
			response.setErrorMesage(GeneralConstants.ERROR_MESSAGE);
			response.setData(null);
		}
		
		return response;

	}
	
	@CrossOrigin
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/deleteUserDetails", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public BaseResponse deleteUserDetails(@RequestBody String userId) {
		
		System.out.println("DeleteUserDetails Contoller called");

		BaseResponse response = new BaseResponse();
		UserDetails user1 = deleteUserDetails.deleteUserDetailsByID(userId);
		
		if(GeneralUtil.getInstance().isNotEmptyObject(user1)) {
			response.setStatus(GeneralConstants.SUCCESS_STATUS);
			response.setData("User Deleted Successfully");
			
		}else {
			response.setStatus(GeneralConstants.ERROR_STATUS);
			response.setErrorMesage(GeneralConstants.ERROR_MESSAGE);
			response.setData(null);
		}
		
		return response;

	}
	
	@GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public String json() {
        return "Greetings Hello World";
    }

}
