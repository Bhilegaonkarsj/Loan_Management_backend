package com.example.model;

import jakarta.validation.constraints.NotNull;

public class LoginDataRequestModel {

	
	@NotNull(message = "user_id is required")
	private Integer user_id;
	private String user_name;
	@NotNull(message = "password is required")
	private String password;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
