package com.example.phonenumbervalidation.service;

import org.springframework.stereotype.Service;

@Service
public interface ValidationService {

	public boolean validatePhonenumber(String phNum);
}
