package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.LoanDataEntity;
import com.example.entity.PaymentDataEntity;
import com.example.entity.UserLoginDetailsEntity;
import com.example.model.LoanDataResponseModel;
import com.example.model.PaymentDataModel;
import com.example.model.RequestDataModel;
import com.example.repository.LoanDataJpaRepository;
import com.example.repository.PaymentDataJpaRepository;
import com.example.service.ValidateService;
import com.example.utils.CommonUtils;
import com.example.utils.Constants;
import com.example.utils.GeneralResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/payments")
public class PaymentDataController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentDataController.class);
	
	@Autowired
	CommonUtils commonUtils;
	
	@Autowired
	ValidateService validateService;
	
	@Autowired
	PaymentDataJpaRepository paymentDataJpaRepository;
	
	@Autowired
	LoanDataJpaRepository loanDataJpaRepository;
	
	@CrossOrigin
	@PostMapping("/summary")
	public ResponseEntity<GeneralResponse> loanApply(	@RequestHeader(value = "userId", required = true) Integer userId,
			@RequestHeader(value = "token", required = true) String token, HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody RequestDataModel requestData)  {
		
		
		ResponseEntity<GeneralResponse> generalResponse = null;
		
		UserLoginDetailsEntity userlogin = validateService.loginValidate(userId, token);

		if (userlogin != null) {

			 generalResponse = commonUtils.jwtCheckProduct(token);	
		
			 try {
				 List<PaymentDataModel>modelList=new ArrayList<>();
				 
				if(requestData!=null) {
						
					List<PaymentDataEntity> paymentList=paymentDataJpaRepository.findByLoanIdAndUserId(requestData.getLoanId(),requestData.getUserId());
				
					if(!paymentList.isEmpty()) {
						for(PaymentDataEntity p:paymentList) {
							PaymentDataModel model=new PaymentDataModel();
							model.setUserId(p.getUserId());
							model.setLoanId(p.getLoanId());
							model.setAccountNumber(p.getAccountNumber());
							model.setTransactionTimestamp(p.getCreatedTimestamp().toString());
							model.setTransactionAmount(p.getAmount());
							model.setTransactionId(p.getId());
							modelList.add(model);
						}
						
						generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
								Constants.REQUEST_COMPLETED_1,modelList,null),HttpStatus.OK);
					}
					else {
						generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
								Constants.REQUEST_COMPLETED_1,"No Transactions Yet",null),HttpStatus.OK);
					}
						
				}	
				
			 }catch(Exception e) {
				 logger.error("Error while fetching payment summary", e);
				 generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 
							Constants.INTERNAL_SERVER_ERROR,null,null),HttpStatus.INTERNAL_SERVER_ERROR);
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
	@PostMapping("/transactions/summary")
	public ResponseEntity<GeneralResponse> getTransactions(	@RequestHeader(value = "userId", required = true) Integer userId,
			@RequestHeader(value = "token", required = true) String token, HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody RequestDataModel requestData)  {
		
		
		ResponseEntity<GeneralResponse> generalResponse = null;
		
		UserLoginDetailsEntity userlogin = validateService.loginValidate(userId, token);

		if (userlogin != null) {

			 generalResponse = commonUtils.jwtCheckProduct(token);	
		
			 try {
				 List<PaymentDataModel>modelList=new ArrayList<>();
				 
				if(requestData!=null) {
						Map<String,List<PaymentDataModel>> payMap=new HashMap<>();
					List<PaymentDataEntity> paymentList=null;
					if(requestData.getAccountIds() != null && !requestData.getAccountIds().isEmpty()) {
						
					 paymentList=paymentDataJpaRepository.findByUserIdAndAccountNumbers(requestData.getUserId(),requestData.getAccountIds());

					}else {
					paymentList=paymentDataJpaRepository.findByUserId(requestData.getUserId());
					}
					
					
					if(!paymentList.isEmpty()) {
						for(PaymentDataEntity p:paymentList) {
							
							String loanType=loanDataJpaRepository.findByLoanIdAndUserId(p.getLoanId(), p.getUserId());
							
							
							
							if (!payMap.containsKey(loanType)) {
							    modelList = new ArrayList<>();
							} else {
							    modelList = payMap.get(loanType);
							}
								PaymentDataModel model=new PaymentDataModel();
								model.setUserId(p.getUserId());
								model.setLoanId(p.getLoanId());
								model.setLoanType(loanType);
								model.setAccountNumber(p.getAccountNumber());
								model.setTransactionTimestamp(p.getCreatedTimestamp().toString());
								model.setTransactionAmount(p.getAmount());
								model.setTransactionId(p.getId());
								modelList.add(model);
								payMap.put(loanType,modelList);

							
						
						}
						
						generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
								Constants.REQUEST_COMPLETED_1,payMap,null),HttpStatus.OK);
					}
					else {
						generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
								Constants.REQUEST_COMPLETED_1,"No Transactions Yet",null),HttpStatus.OK);
					}
						
				}	
				
			 }catch(Exception e) {
				 logger.error("Error while fetching transactions summary", e);
				 generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 
							Constants.INTERNAL_SERVER_ERROR,null,null),HttpStatus.INTERNAL_SERVER_ERROR);
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
