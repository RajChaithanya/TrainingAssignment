package com.example.phonenumbervalidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.phonenumbervalidation.service.ValidationService;

@RestController
public class ValidationController {
	@Autowired
	ValidationService validationserviceObj;
	
	@GetMapping("/")
	public ModelAndView getPhoneNumberPage() {
		ModelAndView mvn = new ModelAndView();
		mvn.setViewName("index.html");
		return mvn;
	}
	
	@PostMapping("/submit")
	public String validatePhone(@RequestParam("phone") String phone) {
		System.out.println("Phone Number :"+phone);
		if(validationserviceObj.validatePhonenumber(phone)) {
			return "Phone number is valid";
		}else {
			return "Phone number should be contain 10 digits";
		}
		
	}

}
