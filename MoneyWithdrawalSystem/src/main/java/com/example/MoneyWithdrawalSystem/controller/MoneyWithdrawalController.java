package com.example.MoneyWithdrawalSystem.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.MoneyWithdrawalSystem.entity.InternationalWithdrawal;
import com.example.MoneyWithdrawalSystem.entity.MoneyWithdrawal;
import com.example.MoneyWithdrawalSystem.entity.TransactionLogs;
import com.example.MoneyWithdrawalSystem.entity.User;
import com.example.MoneyWithdrawalSystem.exception.MWLExceededException;
import com.example.MoneyWithdrawalSystem.service.MonthlyWithdrawalService;

@Controller
@RequestMapping("/MoneyWithdrawalApp")
public class MoneyWithdrawalController {
	
	@Autowired
	MonthlyWithdrawalService monthlyWithdrawalService;	
	
	
	//to remove leading trailing whitespace from input from forms
	@InitBinder
	public void initBinder(WebDataBinder webDatabinder) {
		StringTrimmerEditor stringTrimmer=new StringTrimmerEditor(true);
		
		webDatabinder.registerCustomEditor(String.class, stringTrimmer);
	}
	
	
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/register")
	public String getRegisterForm(@ModelAttribute("user") User theUser) {
		return "register-user";
	}
	
	@RequestMapping("/accountGenerate")
	public String generateAccount(@Valid @ModelAttribute("user") User theUser,
							BindingResult bindingResults) {
		if(bindingResults.hasErrors())
			return "register-user";
		else
		{
			monthlyWithdrawalService.addUser(theUser);
			return "account-generate";
		}
		
	}	
	
	@GetMapping("/withdrawForm")
	public String withdrawForm(@ModelAttribute("moneyWithdrawal") MoneyWithdrawal theMoneyWithdrawal) {
		
		return "withdraw-form";
	}
	
	
	@RequestMapping("/withdrawINR") 
	public String withdrawINR(@Valid @ModelAttribute("moneyWithdrawal") MoneyWithdrawal theMoneyWithdrawal,
			BindingResult bindingResults,
			Model theModel) {
		List<Double> resultList=new ArrayList<Double>();
		
		if(bindingResults.hasErrors()) 
			return "withdraw-form";
		else
		{
			resultList=monthlyWithdrawalService.withdraw(theMoneyWithdrawal);
			theModel.addAttribute("theDenomination",resultList.get(0));
			theModel.addAttribute("theAmount",resultList.get(1));
			theModel.addAttribute("theMWL",resultList.get(2));
			return "withdraw-form";
		}		
	}
	
	//option 3: Mappings for international withdrawal
	@GetMapping("/withdrawInternationalForm")
	public String withdrawInternationalForm(@ModelAttribute("internationalWithdrawal")InternationalWithdrawal theIntrWithdrawal) {
		return "withdraw-international";
	}
	
	@RequestMapping("/withdrawInternational")
	public String withdrawInternational(@Valid @ModelAttribute("internationalWithdrawal")InternationalWithdrawal theIntrWithdrawal,
			BindingResult bindingResults,
			Model theModel) {
		List<Double> resultList=new ArrayList<Double>();
		
		if(bindingResults.hasErrors())
			return "withdraw-international";
		else if(monthlyWithdrawalService.checkNotechoice(theIntrWithdrawal.getCurrency(), theIntrWithdrawal.getNoteChoice()))
		{
			resultList=monthlyWithdrawalService.withdrawInternationalCurrency(theIntrWithdrawal);
			theModel.addAttribute("theTotalWithdraw",resultList.get(0));
			theModel.addAttribute("theBalanceAmount",resultList.get(1));
		}
		
		return "withdraw-international";
	}	
	
	//Option 4: Check Balance mapping
	@GetMapping("/checkBalance")
	public String checkBalance(Model theModel) {
		List<TransactionLogs> tl=monthlyWithdrawalService.getTransactionLogs();
		theModel.addAttribute("transactionLogs",tl);
		return "check-balance";
	}
	
	//Exception Handler for MWL
	@ExceptionHandler(MWLExceededException.class)
	public ModelAndView handleMWLExceededException(MWLExceededException e){
		ModelAndView modelView=new ModelAndView();
		modelView.setViewName("error");
		modelView.addObject("Exception", e.getMessage());
		return modelView;
	}
	
}
