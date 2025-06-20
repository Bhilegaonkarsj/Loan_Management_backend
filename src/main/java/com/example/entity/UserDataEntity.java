package com.example.entity;

import java.io.Serializable;

import jakarta.persistence.Column;

//import javax.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;




@Entity
@Table(name="user_data")
// Define named queries here
@NamedQueries ( {
	@NamedQuery ( name="UserDataEntity.countAll", query="SELECT COUNT(x) FROM UserDataEntity x" )
} )
public class UserDataEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	//----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	//----------------------------------------------------------------------

	    @GeneratedValue(strategy=GenerationType.AUTO)
	//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	//  @SequenceGenerator(name = "SEQ", sequenceName = "ACCOUNT_DETAILS_SEQ")
	@Id
	@Column(name="id", nullable=false)
	private Integer       id ;

	@Column(name="user_name", length=100)
	private String       userName ;

	//----------------------------------------------------------------------
	// ENTITY DATA FIELDS 
	//----------------------------------------------------------------------    
	@Column(name="first_name", length=100)
	private String     firstName ;

	@Column(name="last_name",length=100)
	private String     lastName ;
	
	
	@Column(name="password", length=100)
	private String     password ;
	
	
	@Column(name="mobile_number", length=100)
	private String     mobileNumber ;
	
	
	@Column(name="email_id", length=100)
	private String     emailId ;



	
	
	@Column(name="age")
	private Integer       age ;

	
	@Column(name="annual_Salary")
	private Integer       annualSalary ;
	
	
	@Column(name="occupation", length=100)
	private String     occupation ;


	
	
	


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Integer getAnnualSalary() {
		return annualSalary;
	}


	public void setAnnualSalary(Integer annualSalary) {
		this.annualSalary = annualSalary;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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





	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	
	
	
}
	
	
	
	
