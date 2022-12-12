package com.example.phonenumbervalidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.phonenumbervalidation.service.ValidationService;

@Controller
public class ValidationController {
	@Autowired
	ValidationService validationserviceObj;
	
	@RequestMapping(value = "/validation",method = RequestMethod.GET)
	public String validationForm() {
		return "validation";
	}
	
	@RequestMapping(value = "/validation",method = RequestMethod.POST)
	public String result(ModelMap model, @RequestParam String userName,@RequestParam String phoneNumber) {
		if(validationserviceObj.validatePhonenumber(phoneNumber))  {
			model.put("userName",userName);
			return "result";
		}
		model.put("errorMsg","Phone number should be 10 digits");
		return "validation";
	}
	
	

}
