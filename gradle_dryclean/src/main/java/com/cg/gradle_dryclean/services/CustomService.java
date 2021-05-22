package com.cg.gradle_dryclean.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gradle_dryclean.controller.BookingController;
import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.models.Customer;
import com.cg.gradle_dryclean.repository.ICustomerRepository;

@Service
public class CustomService implements ICustomerService {
	static final Logger LOGGER = LoggerFactory.getLogger(CustomService.class);
	@Autowired
	private ICustomerRepository customerRepository;
	
	//add customer
	public Customer addCustomer(Customer customer) {
		LOGGER.info("customer service - addCustomer method executed");
		return customerRepository.addCustomer(customer);
	}
	
	//Remove customer by customerId
	public Customer removeCustomer(long custId)throws NotFoundException{
		LOGGER.info("customer service - removeCustomer method executed");
		return customerRepository.removeCustomer(custId);
	}
	
	//Update customer by customerId
	public Customer updateCustomer(long custId, Customer customer) throws NotFoundException {
		LOGGER.info("customer service - updateCustomer method executed");
		return customerRepository.updateCustomer(custId, customer);
	}
	
	//Get customer by customerId
	public Customer getCustomer(long custId)throws Exception {
		LOGGER.info("customer service - getCustomer method executed");
		return customerRepository.getCustomer(custId);
	}
	
	//Get all customer
	public List<Customer> getAllCustomers(){
		LOGGER.info("customer service - getAllBooking method executed");
		return customerRepository.getAllCustomers();
	}
}
