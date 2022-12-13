package com.training.customermanagmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.customermanagmentsystem.entities.Customer;

public interface CustomRepo extends JpaRepository<Customer,Integer>{
	
	

}
