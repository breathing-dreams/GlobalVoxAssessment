package com.example.MoneyWithdrawalSystem.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MoneyWithdrawalSystem.entity.InternationalWithdrawal;
import com.example.MoneyWithdrawalSystem.entity.MoneyWithdrawal;
import com.example.MoneyWithdrawalSystem.entity.TransactionLogs;
import com.example.MoneyWithdrawalSystem.entity.User;
import com.example.MoneyWithdrawalSystem.exception.MWLExceededException;

@Service
public class MonthlyWithdrawalService {
	
	@Autowired
	User user;
	
	//List to keep track of all the transactions
	List<TransactionLogs> logs=new ArrayList<TransactionLogs>();
	
	//to check if the first transaction
	static int counter=0;
	
	static double monthlySalary=0;
	static double totalDebitAmount=0;
	static double MWL;	
	
	MonthlyWithdrawalService(){
		
	}
	
	//to add the registered user
	public void addUser(User user) {
		this.user=user;		
		this.addTransactionLogs("new account credit",0.0,user.getMonthlySal());
		monthlySalary=user.getMonthlySal();
		MWL=monthlySalary-monthlySalary*0.5;		
	}

	//service method for withdrawal in INR
	public List<Double> withdraw(MoneyWithdrawal theMoneyWithdrawal) {
		
		List<Double> resultList=new ArrayList<Double>();		
		
		double withdrawalAmount=theMoneyWithdrawal.getWithdrawalAmount();
		
		resultList.add(withdrawalAmount/theMoneyWithdrawal.getDenomination());
		
		double balanceAmount=(monthlySalary-withdrawalAmount);		
		
		user.setMonthlySal(balanceAmount);
		resultList.add(balanceAmount);
		resultList.add(MWL);
		this.addTransactionLogs("Currency Withdrawal in INR",withdrawalAmount, balanceAmount);
		updateCheckMWL();
		return	resultList;
	}
	
	//service method to withdrawal internationally
	public List<Double> withdrawInternationalCurrency(@Valid InternationalWithdrawal theIntrWithdrawal) {
		
			List<Double> resultList=new ArrayList<Double>();
			double exchangeRate=this.getExchangeRate(theIntrWithdrawal.getCurrency());
			double transactionFee=theIntrWithdrawal.getWithdrawAmount()*0.02;
			double totalWithdraw=((theIntrWithdrawal.getWithdrawAmount()*exchangeRate)+transactionFee);
			
			double balanceAmount=(monthlySalary-totalWithdraw);
			user.setMonthlySal(balanceAmount);
			
			resultList.add(totalWithdraw);
			resultList.add(balanceAmount);
			user.setMonthlySal(balanceAmount);
			this.addTransactionLogs("International currency Withdrawal in "+theIntrWithdrawal.getCurrency(),totalWithdraw,balanceAmount);
			updateCheckMWL();
		return resultList;
	}
	
	//method to get exchange rates
	public double getExchangeRate(String currency) {
		if(currency.equals("USD")) 
			return 74.64;			
		else if(currency.equals("AUD"))
			return 51.64;
		else
			return 93.25;
	}
	
	//to check for MWL exception
	public static void updateCheckMWL(){		
		counter++;
		if(counter>1)
			MWL-=5; // for second transaction or more deduct 5 from MWL
			
		if(totalDebitAmount>MWL || totalDebitAmount>monthlySalary) {
			throw new MWLExceededException("Total debit amount is "+totalDebitAmount+". You have exceeded the MWL i.e "+MWL+" or your monthly salary i.e "+monthlySalary);
		}					
	}
	
	//method to add our transaction details
	public void addTransactionLogs(String details,Double debitAmount, Double balance) {
		totalDebitAmount+=debitAmount;
		System.out.println("total debit "+debitAmount);
		logs.add(new TransactionLogs(details,debitAmount,balance));
	}
	
	//method to return our transaction details
	public List<TransactionLogs> getTransactionLogs(){
		return logs;
	}
	
	//to check we get appropriate note choice for international currency withdrawal
	public boolean checkNotechoice(String currency,Integer noteChoice) {
		boolean result=true;
		List<Integer> options;
		
		if(currency.equals("USD")) {
			options=Arrays.asList(10,50,100,500);			
		}
		else if(currency.equals("GBP")) {
			options=Arrays.asList(20,50,500,1000);
		}
		else {			
			options=Arrays.asList(100,500,1000);		
		}
		
		if(!options.contains(noteChoice)) {	
			result=false;
			throw new MWLExceededException("Hi you chose "+currency+" as the withdrawal option. Your note choice must be any of the following "+options);
			
		}
		
		return result;


}
}
