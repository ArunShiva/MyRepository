package com.tcs.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.webapp.constants.GeneralConstants;
import com.tcs.webapp.dto.BaseResponse;
import com.tcs.webapp.model.UserDetails;
import com.tcs.webapp.service.IRetriveUserDetails;
import com.tcs.webapp.utils.GeneralUtil;


@RestController
@RequestMapping("/services")
public class WebAppController extends BaseResponse{

	@Autowired
	IRetriveUserDetails retriveUserDetails;

	@CrossOrigin
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/getUserList", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public BaseResponse getSampleUserList() {
		
		System.out.println("GetSampleUserList Contoller called");

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
	
	@GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public String json() {
        return "Greetings Hello World";
    }

}
