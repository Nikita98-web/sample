package com.cg.gradle_dryclean.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.gradle_dryclean.models.Customer;

@Repository
public interface ICustomerJpa extends JpaRepository<Customer, String>{
	
}
