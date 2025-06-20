package com.example.model;

import java.util.List;

public class LoginDataResponseModel {
	
	
	private String userName;
	private String password;
	private String token;
	private String customerId;
	private String deviceImei;
	private String channel;
	private String ipAddress;
	private String deviceName;
	private Integer userId;
	private String     access         ;
	private List<Integer> permssions;
	private String typeOfApplication;
	private Integer id;
	private Integer productEnable;
	private boolean isExplorer  ;
	private String customerCif;
	
	
	
	
	
	public String getCustomerCif() {
		return customerCif;
	}
	public void setCustomerCif(String customerCif) {
		this.customerCif = customerCif;
	}
	
	public boolean isExplorer() {
		return isExplorer;
	}
	public void setExplorer(boolean isExplorer) {
		this.isExplorer = isExplorer;
	}
	public Integer getProductEnable() {
		return productEnable;
	}
	public void setProductEnable(Integer productEnable) {
		this.productEnable = productEnable;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeOfApplication() {
		return typeOfApplication;
	}
	public void setTypeOfApplication(String typeOfApplication) {
		this.typeOfApplication = typeOfApplication;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getDeviceImei() {
		return deviceImei;
	}
	public void setDeviceImei(String deviceImei) {
		this.deviceImei = deviceImei;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	
	public List<Integer> getPermssions() {
		return permssions;
	}
	public void setPermssions(List<Integer> permssions) {
		this.permssions = permssions;
	}
	@Override
	public String toString() {
		return "LoginDataResponseModel [userName=" + userName + ", password=" + password + ", token=" + token
				+ ", customerId=" + customerId + ", deviceImei=" + deviceImei + ", channel=" + channel + ", ipAddress="
				+ ipAddress + ", deviceName=" + deviceName + ", userId=" + userId + ", access=" + access
				 + ", permssions=" + permssions
				+ ", typeOfApplication=" + typeOfApplication + ", id=" + id + ", productEnable=" + productEnable
				+ ", isExplorer=" + isExplorer + ", customerCif=" + customerCif + "]";
	}
	
	
	

}
