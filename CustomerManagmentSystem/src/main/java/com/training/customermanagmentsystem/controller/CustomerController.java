package com.training.customermanagmentsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.customermanagmentsystem.dto.CustomerDTO;
import com.training.customermanagmentsystem.entities.Customer;
import com.training.customermanagmentsystem.repository.CustomRepo;

@RestController
@RequestMapping("/customersystem")
public class CustomerController {
	
   @Autowired
   CustomRepo customerRepo;
   
   @Autowired
   ModelMapper mapper;
	
   String error = "error";
   
	@PostMapping("/insert")
	public String insertCustomer(@RequestBody CustomerDTO customerDTO) {
		 String message = "";
		 try {
			 System.out.println("data");
			 Customer obj = mapper.map(customerDTO, Customer.class);
			 System.out.println(obj);
			 customerRepo.save(obj);
			 message = "Inserted Successfully";
			 
		 }catch(Exception e) {
			
			 message = error+e; 
		 }
		 return message;
	}
	
	@PutMapping("/update")
	public String updateCustomer(@RequestBody CustomerDTO customerDTO) {
		 String message = "";
		 try {
			 
			 Customer obj = mapper.map(customerDTO, Customer.class);
			 customerRepo.save(obj);
			 message = "Updated Successfully";
			 
			 
		 }catch(Exception e) {
			
			message = error+e; 
		 }
		 return message;
	}
	
	@GetMapping("/get")
	public List<CustomerDTO> getCustomer() {
		
		List<CustomerDTO> allCustomer = new ArrayList<>();
		
		 try {
			  
			 List<Customer> lstCustomer = customerRepo.findAll();
	            for(Customer obj : lstCustomer ) {
	                allCustomer.add(mapper.map(obj,CustomerDTO.class));
	            
	            }
			 
		 }catch(Exception e) {
			System.err.print(error+e);
			 
		 }
		 
		 return allCustomer;
		
	}
	
	@DeleteMapping("/delete")
	public String deleteCustomer(@RequestParam("id") Integer id) {
		String message = "";
		try {
			Customer obj = customerRepo.findById(id).get();
			customerRepo.delete(obj);
			message = "Customer deleted succssfully";
			
			
		}catch(Exception e) {
			
			message =error+e;
			
		}
		
		return message;
	}


}
