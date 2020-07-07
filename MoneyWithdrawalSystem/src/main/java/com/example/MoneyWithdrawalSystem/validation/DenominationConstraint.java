package com.example.MoneyWithdrawalSystem.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DenominationConstraint implements ConstraintValidator<CheckDeno, Integer> {
	
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		boolean result=false;
		ArrayList<Integer> allowedDeno=new ArrayList<Integer>(Arrays.asList(50,100,500,2000));	
		
		if(value!=null) 
			result=allowedDeno.contains(value)? true:false;
		return result;
		
	}

}
