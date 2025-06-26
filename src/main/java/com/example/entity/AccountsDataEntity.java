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
@Table(name="linked_Accounts")
// Define named queries here
@NamedQueries ( {
	@NamedQuery ( name="AccountsDataEntity.countAll", query="SELECT COUNT(x) FROM AccountsDataEntity x" )
} )
public class AccountsDataEntity implements Serializable {
	

    @GeneratedValue(strategy=GenerationType.AUTO)

	@Id
	@Column(name="id", nullable=false)
	private Integer       id ;
	    
	    @Column(name="userId")
		private Integer       userId ;
	    
	    
	    @Column(name="linked_id")
		private Integer       linkedId ;
	    

	    @Column(name="account_number",length=100)
		private String       accountNumber ;
	    
	    @Column(name="bank_id")
		private Integer       bankId ;
	    
	    
	    @Column(name="currency",length=100)
		private String       currency ;
	    

	    
	    @Column(name="initial_balance")
		private Integer       initialBalance ;



		public Integer getId() {
			return id;
		}



		public void setId(Integer id) {
			this.id = id;
		}



		public Integer getUserId() {
			return userId;
		}



		public void setUserId(Integer userId) {
			this.userId = userId;
		}



		public String getAccountNumber() {
			return accountNumber;
		}



		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}



		public Integer getBankId() {
			return bankId;
		}



		public void setBankId(Integer bankId) {
			this.bankId = bankId;
		}



		public String getCurrency() {
			return currency;
		}



		public void setCurrency(String currency) {
			this.currency = currency;
		}



		public Integer getInitialBalance() {
			return initialBalance;
		}



		public void setInitialBalance(Integer initialBalance) {
			this.initialBalance = initialBalance;
		}



		public Integer getLinkedId() {
			return linkedId;
		}



		public void setLinkedId(Integer linkedId) {
			this.linkedId = linkedId;
		}



	    
	    
	    
	    
}
