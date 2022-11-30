package com.example.phonenumbervalidation.service.impl;

import org.springframework.stereotype.Component;

import com.example.phonenumbervalidation.service.ValidationService;

@Component
public class ValidationServiceImpl implements ValidationService{


	@Override
	public boolean validatePhonenumber(String phNum) {
		if(phNum.matches("[0-9]{10}")) {
			return true;
		}else {
		return false;
		}
	}
	
}
