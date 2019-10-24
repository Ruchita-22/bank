package com.nucleus.bank.controllers;

import java.math.BigDecimal;

public class AccountFormBean {

	private String accountNumber;
	private String accountHolderName;
	private BigDecimal accountBalance;

	public AccountFormBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountFormBean(String accountNumber, String accountHolderName, BigDecimal accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

}
