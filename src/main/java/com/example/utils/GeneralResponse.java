package com.example.utils;

public class GeneralResponse {

	
	
	private Integer status;
	private String message;
	private Object data;
	
	private String token;
	public GeneralResponse() {
		super();
	}
	public GeneralResponse(Integer status, String message, Object data, String token) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.token = token;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "GeneralResponse [status=" + status + ", message=" + message + ", data=" + data + ", token=" + token
				+ "]";
	}
}
