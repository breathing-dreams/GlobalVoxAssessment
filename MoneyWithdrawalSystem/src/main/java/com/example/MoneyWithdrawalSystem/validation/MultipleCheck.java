package com.example.MoneyWithdrawalSystem.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MultipleCheck implements ConstraintValidator<InternationalMultiple, Integer>{

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		boolean result=false;		
		
		if(value!=null) {
			result=value%5==0 || value%10==0 ? true:false;
		}			
		
		return result;
	}

}
