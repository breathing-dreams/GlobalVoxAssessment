package com.example.MoneyWithdrawalSystem.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.MoneyWithdrawalSystem.validation.CheckDeno;
import com.example.MoneyWithdrawalSystem.validation.CheckMultiple;

public class MoneyWithdrawal {
	
	@CheckMultiple(message="make sure this amount is a multiple of 100 and the total amount does not exceed MWL")
	@NotNull(message="Please enter a value")
	@Min(value=0, message="Cannot be less than 0")
	private Integer withdrawalAmount;
	
	@CheckDeno(message="Make sure the notes are Rs50, Rs100, Rs500 or Rs2000")
	@NotNull(message="Please enter a value")
	private Integer denomination;
	
	MoneyWithdrawal(){
		
	}
	
	public MoneyWithdrawal(Integer withdrawalAmount, Integer denomination) {
		super();
		this.withdrawalAmount = withdrawalAmount;
		this.denomination = denomination;
	}
	public Integer getWithdrawalAmount() {
		return withdrawalAmount;
	}
	public void setWithdrawalAmount(Integer withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}
	public Integer getDenomination() {
		return denomination;
	}
	public void setDenomination(Integer denomination) {
		this.denomination = denomination;
	}
	
	

}
