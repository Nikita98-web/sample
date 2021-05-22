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

import com.cg.gradle_dryclean.models.CustomerItem;
import com.cg.gradle_dryclean.services.ICustomerItemService;


@RestController
@RequestMapping("/customeritem")
public class CustomerItemController {
	
static final Logger LOGGER = LoggerFactory.getLogger(CustomerItemController.class);
	
	@Autowired
	private ICustomerItemService customerItemService;
	
	//Add CustomerItem 
	@PostMapping("/add")
	public CustomerItem addItem(@RequestBody CustomerItem item) {
		LOGGER.info("/customeritem/add URL is opened");
		LOGGER.info("add Customer method executed");
		return customerItemService.addItem(item);
	}
	
	//Remove CustomerItem by id
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> removeItem(@PathVariable long id)throws Exception {
		LOGGER.info("/customeritem//remove/{id} URL is opened");
		LOGGER.info("Remove Customer method executed");
		ResponseEntity<Object> response = null;
		CustomerItem ci= customerItemService.removeItem(id);
		response = new ResponseEntity<Object>(ci, HttpStatus.OK);
		return response;
	}
	
	//Update CustomerItem by id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateItem(@PathVariable long id,@RequestBody CustomerItem item) throws Exception{
		LOGGER.info("/customeritem/update/{id} URL is opened");
		LOGGER.info("Update Customer method executed");
		ResponseEntity<Object> response = null;
		CustomerItem ci=customerItemService.updateItem(id, item);
		response = new ResponseEntity<Object>(ci, HttpStatus.ACCEPTED);
		return response;
	}
	
	//Get Item by id
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getItem(@PathVariable long id) throws Exception{
		LOGGER.info("/customeritem/get/{id} URL is opened");
		LOGGER.info("Get Customer method executed");
		ResponseEntity<Object> response = null;
		CustomerItem ci= customerItemService.getItem(id);
		response = new ResponseEntity<Object>(ci, HttpStatus.OK);
		return response;
	}
	
	//Get by customerId
	@GetMapping("/getbycustomer/{customerId}")
	public ResponseEntity<Object> getItemsByCustomer(@PathVariable long customerId)throws Exception{
		LOGGER.info("/customeritem/getbycustomer/{customerId URL is opened");
		LOGGER.info("Get Customer method executed");
		ResponseEntity<Object> response = null;
		List<CustomerItem> ci= customerItemService.getItemsByCustomer(customerId);
		response = new ResponseEntity<Object>(ci, HttpStatus.OK);
		return response;
	}

}
