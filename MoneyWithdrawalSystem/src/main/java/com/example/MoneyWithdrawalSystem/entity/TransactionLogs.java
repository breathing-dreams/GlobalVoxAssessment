package com.example.MoneyWithdrawalSystem.entity;

import org.springframework.stereotype.Component;

@Component
public class TransactionLogs {
	
	private String details;
	
	private Double balance;
	
	private Double finalBalance;
	
	TransactionLogs(){
		
	}
	
	public TransactionLogs(String details, Double totalWithdraw, Double balanceAmount) {
		this.details = details;
		this.balance = totalWithdraw;
		this.finalBalance=balanceAmount;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getFinalBalance() {
		return finalBalance;
	}

	public void setFinalBalance(Double finalBalance) {
		this.finalBalance = finalBalance;
	}

	

}
