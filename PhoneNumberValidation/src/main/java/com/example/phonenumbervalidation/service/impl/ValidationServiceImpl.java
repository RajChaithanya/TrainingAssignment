package com.example.phonenumbervalidation.service.impl;

import org.springframework.stereotype.Component;

import com.example.phonenumbervalidation.service.ValidationService;

@Component
public class ValidationServiceImpl implements ValidationService{


	@Override
	public boolean validatePhonenumber(String phNum) {
		if(phNum.matches("^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$")){
			return true;
		}else {
		return false;
		}
	}
	
}
