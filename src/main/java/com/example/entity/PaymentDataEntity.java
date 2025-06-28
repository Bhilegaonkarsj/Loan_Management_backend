package com.example.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//Loan { id, userId, loanAmount, interestRate, tenureMonths, status (ACTIVE/PAID), createdAt }
@Entity
@Table(name="payments")
// Define named queries here
@NamedQueries ( {
	@NamedQuery ( name="PaymentDataEntity.countAll", query="SELECT COUNT(x) FROM PaymentDataEntity x" )
} )
public class PaymentDataEntity implements Serializable {

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
	    
	    @Column(name="userId")
		private Integer       userId ;
	    
	    @Column(name="loanId")
		private Integer       loanId ;
	    
	    @Column(name="amount")
		private Integer       amount ;
	    
	    
	    @Column(name="account_number")
		private String       accountNumber ;
	    
	    
		@Temporal(TemporalType.TIMESTAMP)
	    @Column(name="createdAt")
		private Date       createdTimestamp ;

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

		public Integer getLoanId() {
			return loanId;
		}

		public void setLoanId(Integer loanId) {
			this.loanId = loanId;
		}

		public Date getCreatedTimestamp() {
			return createdTimestamp;
		}

		public void setCreatedTimestamp(Date createdTimestamp) {
			this.createdTimestamp = createdTimestamp;
		}

		public Integer getAmount() {
			return amount;
		}

		public void setAmount(Integer amount) {
			this.amount = amount;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

				    
		    
		    
		    


}
