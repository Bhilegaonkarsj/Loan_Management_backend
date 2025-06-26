package com.example.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.LoanDataEntity;
import com.example.entity.UserLoginDetailsEntity;
import com.example.model.LoanDataResponseModel;
import com.example.model.LoginDataResponseModel;
import com.example.model.RequestDataModel;
import com.example.repository.LoanDataJpaRepository;
import com.example.service.ValidateService;
import com.example.utils.CommonUtils;
import com.example.utils.Constants;
import com.example.utils.GeneralResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/loans")
public class LoanDataController {

	LoginDataResponseModel authenticateUserResponse = null;

//	@Autowired
//	private CommonUtils commonUtils;
	
	@Autowired
	LoanDataJpaRepository loanDataJpaRepository;
	@Autowired
	ValidateService validateService;
	
	@Autowired
	CommonUtils commonUtils;
	
	
	@CrossOrigin
	@PostMapping("/apply")
	public ResponseEntity<GeneralResponse> loanApply(	@RequestHeader(value = "userId", required = true) Integer userId,
			@RequestHeader(value = "token", required = true) String token, HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody RequestDataModel requestData)  {
		
		
		ResponseEntity<GeneralResponse> generalResponse = null;
		
		UserLoginDetailsEntity userlogin = validateService.loginValidate(userId, token);

		if (userlogin != null) {

			 generalResponse = commonUtils.jwtCheckProduct(token);	
		
			 try {
				 List<LoanDataResponseModel>modelList=new ArrayList<>();
				 
				if(requestData!=null) {
						
						LoanDataEntity entity=new LoanDataEntity();
						
						entity.setUserId(requestData.getUserId());
						entity.setLoanType(requestData.getLoanType());
						entity.setLoanAmount(requestData.getAmount());
						entity.setTotalAmount(requestData.getTotalAmount());
						
						
						entity.setAccountNumber(requestData.getAccountNumber());
						entity.setCreatedTimestamp(new Date());
						entity.setReason(requestData.getReason());
						
                       loanDataJpaRepository.save(entity);						
					}
						generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
								Constants.REQUEST_COMPLETED_1,"Data Saved",null),HttpStatus.OK);
							
				
			 }catch(Exception e) {
				 
			 }
		
	}else {
		generalResponse = new ResponseEntity<GeneralResponse>(
				new GeneralResponse(HttpServletResponse.SC_UNAUTHORIZED,
						Constants.INVALID_USER, HttpServletResponse.SC_CONFLICT, null),
				HttpStatus.OK);
	}
		return generalResponse;

	}
	
	
	
	@CrossOrigin
	@PostMapping("/check")
	public ResponseEntity<GeneralResponse> loanCheck(	@RequestHeader(value = "userId", required = true) Integer userId,
			@RequestHeader(value = "token", required = true) String token, HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody RequestDataModel requestData)  {
		
		
		ResponseEntity<GeneralResponse> generalResponse = null;
		
		UserLoginDetailsEntity userlogin = validateService.loginValidate(userId, token);

		if (userlogin != null) {

			 generalResponse = commonUtils.jwtCheckProduct(token);	
		
			 try {
				 List<LoanDataResponseModel>modelList=new ArrayList<>();
				List<LoanDataEntity> loansdata=loanDataJpaRepository.findByLoanTypeAndUserId(requestData.getLoanType(),requestData.getUserId());
				 
				if(loansdata!=null) {
					for(LoanDataEntity l:loansdata) {
						
						LoanDataResponseModel model=new LoanDataResponseModel();
						
						model.setLoanId(l.getId());
						model.setUserId(l.getUserId());
						model.setLoanType(l.getLoanType());
						model.setLoanAmount(l.getLoanAmount());
						model.setPaidAmount(l.getAmountSaved());
						model.setCreatedTimestamp(l.getCreatedTimestamp().toString());
						model.setReason(l.getReason());
						
						modelList.add(model);
						
					}
						generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
								Constants.REQUEST_COMPLETED_1,modelList,null),HttpStatus.OK);
							
				
				}else {
					generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
							Constants.REQUEST_COMPLETED_1,"User Does Not have any loan",null),HttpStatus.OK);
				}
			 }catch(Exception e) {
				 
			 }
		
		
		
		
	}else {
		generalResponse = new ResponseEntity<GeneralResponse>(
				new GeneralResponse(HttpServletResponse.SC_UNAUTHORIZED,
						Constants.INVALID_USER, HttpServletResponse.SC_CONFLICT, null),
				HttpStatus.OK);
	}
		return generalResponse;

	}
	
}
