package com.example.MoneyWithdrawalSystem.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MWLConstraint implements ConstraintValidator<CheckMultiple, Integer>{
	int totalValue=0;
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		boolean result=false;		
		
		if(value!=null) {
			result=value%100==0? true:false;
		}			
		
		return result;
	}

}
