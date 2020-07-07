package com.example.MoneyWithdrawalSystem.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.example.MoneyWithdrawalSystem.exception.MWLExceededException;
import com.example.MoneyWithdrawalSystem.validation.InternationalMultiple;

public class InternationalWithdrawal {
	
	private String currency;
	
	private Map<String,String> currencyOptions;
	
	private Integer noteChoice;
	
	@InternationalMultiple
	@NotNull(message = "is required")
	private Integer withdrawAmount;
	
	InternationalWithdrawal(){
		currencyOptions=new HashMap<String,String>();
		currencyOptions.put("USD", " US Dollar");
		currencyOptions.put("GBP", " British Pound Sterling");
		currencyOptions.put("AUD", " Australian Dollar");
	}

	public Integer getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(Integer withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public Map<String, String> getCurrencyOptions() {
		return currencyOptions;
	}

	public void setCurrencyOptions(Map<String, String> currencyOptions) {
		this.currencyOptions = currencyOptions;
	}

	public Integer getNoteChoice() {
		return noteChoice;
	}

	public void setNoteChoice(Integer noteChoice) {		
			this.noteChoice=noteChoice;
	}

	
}
