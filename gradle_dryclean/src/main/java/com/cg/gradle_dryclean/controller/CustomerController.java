package com.cg.gradle_dryclean.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.models.Customer;
import com.cg.gradle_dryclean.services.ICustomerService;



@RestController
@RequestMapping("/customer")
public class CustomerController {
	
static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private ICustomerService customerService;
	
	//Add Custommer
	@PostMapping("/add")
	Customer addCustomer(@RequestBody Customer customer) {
		LOGGER.info("/customer/add URL is opened");
		LOGGER.info("addCustomer method executed");
		return customerService.addCustomer(customer);
	}
	
	//Remove customer by customerId
	@DeleteMapping("/remove/{custId}")
	public ResponseEntity<Object> removeCustomer(@PathVariable long custId) throws NotFoundException{
		LOGGER.info("/customer/remove/{custId} URL is opened");
		LOGGER.info("Remove Customer method executed");
		ResponseEntity <Object>response=null;
		Customer c = customerService.removeCustomer(custId);
		response=new ResponseEntity<Object>(c,HttpStatus.OK);
		return response;
	}
	
	//Update Customer by CustomerId
	@PutMapping("/update/{custId}")
	public ResponseEntity <Object> updateCustomer(@PathVariable long custId,@RequestBody Customer customer)throws NotFoundException {
		LOGGER.info("/customer/update/{custId} URL is opened");
		LOGGER.info("Update Customer method executed");
		ResponseEntity <Object>response=null;
		
			Customer c = customerService.updateCustomer(custId, customer);
			response=new ResponseEntity<>(c, HttpStatus.ACCEPTED);
			return response;
	}
	
	//Get customer by customerId
	@GetMapping("/get/{custId}")
	public ResponseEntity <Object> getCustomer(@PathVariable long custId)throws Exception {
		LOGGER.info("/customer/get/{custId} URL is opened");
		LOGGER.info("Get Customer method executed");
		ResponseEntity <Object>response=null;
		Customer c= customerService.getCustomer(custId);
		response=new ResponseEntity<>(c, HttpStatus.ACCEPTED);		
		return response;
	}
	
	//Get all customers
	@GetMapping("/get")
	public List<Customer> getAllCustomers(){
		LOGGER.info("/customer/get URL is opened");
		LOGGER.info("GetAll Customer method executed");
		return customerService.getAllCustomers();
	}
	

}
