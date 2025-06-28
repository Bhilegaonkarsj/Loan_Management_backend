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
@Table(name="loan_data")
// Define named queries here
@NamedQueries ( {
	@NamedQuery ( name="LoanDataEntity.countAll", query="SELECT COUNT(x) FROM LoanDataEntity x" )
} )
public class LoanDataEntity implements Serializable {

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
	    

	    @Column(name="account_number",length=100)
		private String       accountNumber ;
	    
	    @Column(name="balance_amount")
		private Integer       balanceAmount ;
	    
	    
	    
	    
	    @Column(name="loan_amount")
		private Integer       loanAmount ;
	    
	    @Column(name="intrestRate")
		private Integer       intrestRate ;
	    
	    @Column(name="tenureMonths")
		private Integer      tenureMonths ;
	    
	    @Column(name="status")
		private Integer      status ;
	    
		@Temporal(TemporalType.TIMESTAMP)
	    @Column(name="createdAt")
		private Date       createdTimestamp ;
		
		
		@Column(name="loan_type",length=100)
		private String loanType;
		
		@Column(name="amount_saved")
		private Integer amountSaved;
		
		@Column(name="reason",length=100)
		private String reason;
	
		
		
		   @Column(name="totalAmount")
			private Integer       totalAmount ;

		public String getLoanType() {
			return loanType;
		}

		public void setLoanType(String loanType) {
			this.loanType = loanType;
		}

		public Integer getAmountSaved() {
			return amountSaved;
		}

		public void setAmountSaved(Integer amountSaved) {
			this.amountSaved = amountSaved;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

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

		public Integer getLoanAmount() {
			return loanAmount;
		}

		public void setLoanAmount(Integer loanAmount) {
			this.loanAmount = loanAmount;
		}

		public Integer getIntrestRate() {
			return intrestRate;
		}

		public void setIntrestRate(Integer intrestRate) {
			this.intrestRate = intrestRate;
		}

		public Integer getTenureMonths() {
			return tenureMonths;
		}

		public void setTenureMonths(Integer tenureMonths) {
			this.tenureMonths = tenureMonths;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Date getCreatedTimestamp() {
			return createdTimestamp;
		}

		public void setCreatedTimestamp(Date createdTimestamp) {
			this.createdTimestamp = createdTimestamp;
		}

		public Integer getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(Integer totalAmount) {
			this.totalAmount = totalAmount;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public Integer getBalanceAmount() {
			return balanceAmount;
		}

		public void setBalanceAmount(Integer balanceAmount) {
			this.balanceAmount = balanceAmount;
		}
		    
		    
		    
		    
		    
		    


}
