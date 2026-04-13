package com.example.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.entity.PaymentDataEntity;
import com.example.entity.UserLoginDetailsEntity;
import com.example.model.LoanDataResponseModel;
import com.example.model.LoginDataResponseModel;
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
@RequestMapping("/api/loans")
public class LoanDataController {

	LoginDataResponseModel authenticateUserResponse = null;

//	@Autowired
//	private CommonUtils commonUtils;
	
	@Autowired
	LoanDataJpaRepository loanDataJpaRepository;
	
	@Autowired
	PaymentDataJpaRepository paymentDataJpaRepository;
	
	
	@Autowired
	ValidateService validateService;
	
	@Autowired
	CommonUtils commonUtils;
	
	Logger logger=LoggerFactory.getLogger("Success");
	Logger loggerfailure=LoggerFactory.getLogger("Failure");



	@CrossOrigin
	@PostMapping("/apply")
	public ResponseEntity<GeneralResponse> loanApply(	@RequestHeader(value = "userId", required = true) Integer userId,
			@RequestHeader(value = "token", required = true) String token, HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody RequestDataModel requestData)  {
		
		
		ResponseEntity<GeneralResponse> generalResponse = null;
		
		UserLoginDetailsEntity userlogin = validateService.loginValidate(userId, token);

		if (userlogin != null) {


			logger.info("------------------------Start Applying to loan---------------------------------");
			 generalResponse = commonUtils.jwtCheckProduct(token);	
		
			 try {
				 List<LoanDataResponseModel>modelList=new ArrayList<>();
				 
				if(requestData!=null) {
						
					LoanDataEntity entity=loanDataJpaRepository.findByLoanTypeAndUserId(requestData.getLoanType(), requestData.getUserId());
					
					
					if(entity!=null) {
						
						System.out.println("Entity::::"+entity.getUserId());
						
						entity.setAccountNumber(requestData.getAccountNumber());
						entity.setLoanAmount(requestData.getLoanAmount());
						entity.setAmountSaved(entity.getAmountSaved() +requestData.getLoanAmount());
						loanDataJpaRepository.save(entity);
						

	                       PaymentDataEntity paymentEntity=new PaymentDataEntity();
	                       paymentEntity.setLoanId(entity.getId());
	                       paymentEntity.setUserId(entity.getUserId());
	                       paymentEntity.setAccountNumber(entity.getAccountNumber());
	                       paymentEntity.setAmount(entity.getLoanAmount());
	                       paymentEntity.setCreatedTimestamp(new Date());
	                       paymentDataJpaRepository.save(paymentEntity);
					}
					else {
					 entity=new LoanDataEntity();
						
						
						entity.setUserId(requestData.getUserId());
						entity.setLoanType(requestData.getLoanType());
						entity.setLoanAmount(requestData.getLoanAmount());
						entity.setTotalAmount(requestData.getTotalAmount());
						entity.setAmountSaved(requestData.getLoanAmount());
						
						entity.setAccountNumber(requestData.getAccountNumber());
						entity.setCreatedTimestamp(new Date());
						entity.setReason(requestData.getReason());
						
                       loanDataJpaRepository.save(entity);	
                       
                       
                       
                       PaymentDataEntity paymentEntity=new PaymentDataEntity();
                       paymentEntity.setLoanId(entity.getId());
                       paymentEntity.setUserId(entity.getUserId());
                       paymentEntity.setAccountNumber(entity.getAccountNumber());
                       paymentEntity.setAmount(entity.getLoanAmount());
                       paymentEntity.setCreatedTimestamp(new Date());
                       paymentDataJpaRepository.save(paymentEntity);
					}
				
					System.out.println("entity saved");
						generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
								Constants.REQUEST_COMPLETED_1,"Data Saved",null),HttpStatus.OK);
				}	
				
			 }catch(Exception e) {
				 loggerfailure.error("Error while applying loan", e);
				 generalResponse = new ResponseEntity<GeneralResponse>(
							new GeneralResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
									Constants.INTERNAL_SERVER_ERROR, null, null),
							HttpStatus.INTERNAL_SERVER_ERROR);
			 }
		
	}else {
		
		
		generalResponse = new ResponseEntity<GeneralResponse>(
				new GeneralResponse(HttpServletResponse.SC_UNAUTHORIZED,
						Constants.INVALID_USER, HttpServletResponse.SC_CONFLICT, null),
				HttpStatus.OK);
	}


	logger.info("------------------------------------End of applying Loan----------------------------");
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
				LoanDataEntity l=loanDataJpaRepository.findByLoanTypeAndUserId(requestData.getLoanType(),requestData.getUserId());
				 
				if(l!=null) {
//					for(LoanDataEntity l:loansdata) {
						
						LoanDataResponseModel model=new LoanDataResponseModel();
						
						model.setLoanId(l.getId());
						model.setUserId(l.getUserId());
						model.setLoanType(l.getLoanType());
						model.setTotalAmountForLoan(l.getTotalAmount());
						model.setLoanAmount(l.getLoanAmount());
						model.setPaidAmount(l.getAmountSaved());
						model.setRemianingAmount(l.getTotalAmount()-l.getAmountSaved());
						model.setCreatedTimestamp(l.getCreatedTimestamp().toString());
						model.setReason(l.getReason());
						
						modelList.add(model);
						
//					}
						generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
								Constants.REQUEST_COMPLETED_1,modelList,null),HttpStatus.OK);
							
				
				}else {
					generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
							Constants.REQUEST_COMPLETED_1,"User Does Not have any loan",null),HttpStatus.OK);
				}
			 }catch(Exception e) {
				 loggerfailure.error("Error while checking loan", e);
				 generalResponse = new ResponseEntity<GeneralResponse>(
							new GeneralResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
									Constants.INTERNAL_SERVER_ERROR, null, null),
							HttpStatus.INTERNAL_SERVER_ERROR);
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
