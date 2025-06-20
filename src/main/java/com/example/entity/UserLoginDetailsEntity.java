package com.example.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


	
	
	

@Entity
@Table(name="user_login")
// Define named queries here
@NamedQueries ( {
	@NamedQuery ( name="UserLoginDetailsEntity.countAll", query="SELECT COUNT(x) FROM UserLoginDetailsEntity x" )
} )
public class UserLoginDetailsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	//----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	//----------------------------------------------------------------------

	    @GeneratedValue(strategy=GenerationType.AUTO)
	//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	//  @SequenceGenerator(name = "SEQ", sequenceName = "ACCOUNT_DETAILS_SEQ")
	@Id
	@Column(name="id", nullable=false)
	private Long       id ;

	@Column(name="user_id")
	private Integer       userId ;

	//----------------------------------------------------------------------
	// ENTITY DATA FIELDS 
	//----------------------------------------------------------------------    
	@Column(name="token", length=1000)
	private String     token ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer integer) {
		this.userId = integer;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	
	
}
