// package com.example.controller;


// import java.io.UnsupportedEncodingException;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestHeader;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.utils.Constants;
// import com.example.entity.UserDataEntity;
// import com.example.entity.UserLoginDetailsEntity;
// import com.example.model.LoginDataRequestModel;
// import com.example.model.LoginResponseModel;
// import com.example.model.NewUserModel;
// import com.example.repository.UserDataJpaRepository;
// import com.example.repository.UserLoginJpaRepository;
// import com.example.utils.GeneralResponse;
// import com.example.utils.JwtUtil;
// import com.google.gson.Gson;

// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;


// @RestController
// @RequestMapping("api/user") 
// public class UserDataController {

	
	
// 	@Autowired
// 	UserDataJpaRepository userDataJpaRepository;
	
	
// 	@Autowired
// 	UserLoginJpaRepository userLoginJpaRepository;
	
	
	
	
// 	//Login API
// 	@CrossOrigin
// 	@PostMapping("/login")
// 	public ResponseEntity<GeneralResponse> login(	HttpServletRequest request,HttpServletResponse response,
// 			@RequestBody LoginDataRequestModel requestData) throws UnsupportedEncodingException{
		
// 		ResponseEntity<GeneralResponse> generalResponse = null;
		
		
// 		System.out.println("api hit successful?");
// 		if(requestData!=null) {
			
// 			String token=null;
// 			UserDataEntity user=userDataJpaRepository.findByUserId(requestData.getUser_id());
			
			
// 			System.out.println("come here:::"+user);
// 			if(user!=null) {
				
// 				int expiresIn =0;
				
// //					expiresIn = Integer.parseInt(dashboardConfigurationEntity.getDashVal());
				
// 				token = JwtUtil.createJWTToken(new Gson().toJson(requestData), expiresIn);
				
				
// 				UserLoginDetailsEntity userLogin=userLoginJpaRepository.findbyUserId(requestData.getUser_id());
				
				
// 				if(userLogin!=null) {
// 					userLogin.setToken(token);
// 					userLoginJpaRepository.save(userLogin);

// 				}else {
// 				UserLoginDetailsEntity userLoginDetailsEntity=new UserLoginDetailsEntity();
// 				userLoginDetailsEntity.setToken(token);
// 				userLoginDetailsEntity.setUserId(user.getId());
// 				userLoginJpaRepository.save(userLoginDetailsEntity);
				
// 				}
				
// 		LoginResponseModel loginModel=new LoginResponseModel();
		
		
// 		loginModel.setFullName(user.getFirstName() +" "+user.getLastName());
// 		loginModel.setToken(token);
// 		loginModel.setUserId(user.getId());
// 		loginModel.setUserName(user.getUserName());
		
		
		
		
// 		generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
// 				Constants.REQUEST_COMPLETED_1,loginModel,token),HttpStatus.OK);
			
// 			}
// 		}
// 		return generalResponse;
// 	}
	
	
	
// //User creation
// 	@CrossOrigin
// 	@PostMapping("/signup")
// 	public ResponseEntity<GeneralResponse> createAProfile(	HttpServletRequest request,HttpServletResponse response,
// 			@RequestBody NewUserModel requestData) throws UnsupportedEncodingException{
		
// 		ResponseEntity<GeneralResponse> generalResponse = null;
		
		
// 		System.out.println("api hit successful?");
// 		if(requestData!=null) {
			
// 			String token=null;
// 			UserDataEntity user=userDataJpaRepository.findbyUserIdAndMobileNo(requestData.getUser_name(),requestData.getMobileNo());
			
			
// 			System.out.println("come here:::"+user);
			
// 			if(user==null) {
// 				UserDataEntity userData=new UserDataEntity();
// 				userData.setFirstName(requestData.getFirstName());
// 				userData.setLastName(requestData.getLastName());
// 				userData.setMobileNumber(requestData.getMobileNo());
// 				userData.setUserName(requestData.getUser_name());
// 				userData.setEmailId(requestData.getEmailId());
// 				userData.setPassword("1234");
// 				userData.setAge(requestData.getAge());
// 				userData.setAnnualSalary(requestData.getAnnualSalary());
// 				userData.setOccupation(requestData.getOccupation());
// 				userDataJpaRepository.save(userData);
				
				

// 				generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
// 						Constants.REQUEST_COMPLETED_1,"User Profile Created",null),HttpStatus.OK);
					
// 					}
			
// 			else {
		
// 		generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
// 				Constants.REQUEST_COMPLETED_1,"Account Aready has been Created.You want to sign in?",null),HttpStatus.OK);
			
// 			}
// 		}
		
// 		return generalResponse;
// 	}
	
	
	
	
// 	//User profile details
	
	
// 	@CrossOrigin
// 	@PostMapping("/details")
// 	public ResponseEntity<GeneralResponse> userDetails(@RequestHeader(value = "userId", required = true) String userId,
// 			@RequestHeader(value = "token", required = true) String token, HttpServletRequest request,
// 			HttpServletResponse response,
// 			@RequestBody  NewUserModel requestData) throws UnsupportedEncodingException{
		
// 		ResponseEntity<GeneralResponse> generalResponse = null;
		
		
// 		System.out.println("api hit successful?");
// 		if(requestData!=null) {
			
// 			String token=null;
			
			
// 			UserLoginDetailsEntity
// 			UserDataEntity user=userDataJpaRepository.findbyUserIdAndMobileNo(requestData.getUser_name(),requestData.getMobileNo());
			
			
// 			System.out.println("come here:::"+user);
			
// 			if(user==null) {
// 				UserDataEntity userData=new UserDataEntity();
// 				userData.setFirstName(requestData.getFirstName());
// 				userData.setLastName(requestData.getLastName());
// 				userData.setMobileNumber(requestData.getMobileNo());
// 				userData.setUserName(requestData.getUser_name());
// 				userData.setEmailId(requestData.getEmailId());
// 				userData.setPassword("1234");
// 				userData.setAge(requestData.getAge());
// 				userData.setAnnualSalary(requestData.getAnnualSalary());
// 				userData.setOccupation(requestData.getOccupation());
// 				userDataJpaRepository.save(userData);
				
				

// 				generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
// 						Constants.REQUEST_COMPLETED_1,"User Profile Created",null),HttpStatus.OK);
					
// 					}
			
// 			else {
		
// 		generalResponse=new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_OK, 
// 				Constants.REQUEST_COMPLETED_1,"Account Aready has been Created.You want to sign in?",null),HttpStatus.OK);
			
// 			}
// 		}
		
// 		return generalResponse;
// 	}
	
	
	
// }
