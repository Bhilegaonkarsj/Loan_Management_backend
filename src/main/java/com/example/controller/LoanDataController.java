package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.LoginDataResponseModel;
import com.example.model.RequestDataModel;
import com.example.utils.CommonUtils;
import com.example.utils.GeneralResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/loans")
public class LoanDataController {

	LoginDataResponseModel authenticateUserResponse = null;

//	@Autowired
//	private CommonUtils commonUtils;
	
	
	@PostMapping("/apply")
	public ResponseEntity<GeneralResponse> login(	@RequestHeader(value = "userId", required = true) String customerIdh,
			@RequestHeader(value = "token", required = true) String token, HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody RequestDataModel requestData)  {
		
		
		ResponseEntity<GeneralResponse> generalResponse = null;
//		commonUtils.jwtCheckProduct(token);
		if (generalResponse.getBody().getStatus() == 200) {
			authenticateUserResponse = (LoginDataResponseModel) generalResponse.getBody().getData();
		} else {
			return generalResponse;
		}
		
		
		
		
		
		return generalResponse;
	}
	
}
