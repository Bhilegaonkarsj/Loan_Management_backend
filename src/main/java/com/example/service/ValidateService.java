package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.entity.UserLoginDetailsEntity;
import com.example.repository.UserLoginJpaRepository;





@Service
public class ValidateService {
	
	@Autowired
	UserLoginJpaRepository customerUserLoginJpaRepository;
	
	
	
	public UserLoginDetailsEntity loginValidate(Integer userId, String loginToken){
		
		System.out.println("header customerId service is:"+userId);
		System.out.println("sec key "+loginToken);
		
		UserLoginDetailsEntity customerUserLogin = customerUserLoginJpaRepository.findByUserIdAndToken(userId, loginToken);
		
		System.out.println("service cust is:"+customerUserLogin);
		

		if(customerUserLogin!=null){
			System.out.println("success....");
			return customerUserLogin;
			
		}
		else {
		
			System.out.println("fail-");
		return null;
		}

		
	}
		
		
}
