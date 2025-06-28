package com.example.model;

import java.util.List;

public class AccountsModel {

	
	private Integer userId;
	private List<String> accountsList;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<String> getAccountsList() {
		return accountsList;
	}
	public void setAccountsList(List<String> accountsList) {
		this.accountsList = accountsList;
	}
	
	
	
}
