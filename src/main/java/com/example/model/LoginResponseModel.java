package com.example.model;

public class LoginResponseModel {

	
	private Integer userId;
	private String userName;
	private String token;
	private String fullName;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer integer) {
		this.userId = integer;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	
	
}
