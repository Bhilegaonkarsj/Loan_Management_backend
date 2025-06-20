package com.example.model;

import java.util.Objects;

public class NewUserModel {



	
	private String user_name;
	private String firstName;
	private String lastName;
	private String password;
	private String mobileNo;
	private Integer age;
	private String occupation;
	private Integer annualSalary;
	
	private String emailId;
	
	
	
	
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Integer getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(Integer annualSalary) {
		this.annualSalary = annualSalary;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, annualSalary, mobileNo, occupation, password, user_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewUserModel other = (NewUserModel) obj;
		return Objects.equals(age, other.age) && Objects.equals(annualSalary, other.annualSalary)
				&& Objects.equals(mobileNo, other.mobileNo) && Objects.equals(occupation, other.occupation)
				&& Objects.equals(password, other.password) && Objects.equals(user_name, other.user_name);
	}
	@Override
	public String toString() {
		return "NewUserModel [user_name=" + user_name + ", password=" + password + ", mobileNo=" + mobileNo + ", age="
				+ age + ", occupation=" + occupation + ", annualSalary=" + annualSalary + "]";
	}
	
	
	
	
	
	
	
	
	
}
