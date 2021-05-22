package com.cg.gradle_dryclean.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.jpa.*;
import com.cg.gradle_dryclean.models.Customer;
@Repository
public class CustomerRepository  implements ICustomerRepository{
	@Autowired
	private ICustomerJpa customerjpa;
	
	public Customer addCustomer(Customer customer) {
		customerjpa.save(customer);
		return customer;
	}
	
	public Customer removeCustomer(long custId) throws NotFoundException {
		Optional<Customer> oc = customerjpa.findById(Long.toString(custId));
		if(oc.isPresent()) {
			Customer c = oc.get();
			customerjpa.delete(c);
			return c;
		}
		else
			throw new NotFoundException("Customer id not found");
			
	}
	
	public Customer updateCustomer(long custId, Customer customer) throws NotFoundException {
		Optional<Customer> oc = customerjpa.findById(Long.toString(custId));
		
		if(oc.isPresent()) {
			
			Customer c = oc.get();
			c.setUserId(customer.getUserId());
			c.setName(customer.getName());
			c.setAddress(customer.getAddress());
			c.setEmail(customer.getEmail());
			c.setDob(customer.getDob());
			c.setContactNo(customer.getContactNo());
			customerjpa.save(c);
			return c;
		}
		else
			throw new NotFoundException("User Id is not valid");
		
	}
	
	public Customer getCustomer(long custId) throws Exception {
		Optional<Customer> oc = customerjpa.findById(Long.toString(custId));
		if(oc.isPresent()) {
			Customer c=oc.get();
			return c;
		}
		else 
			throw new NotFoundException("Customer id is not present");
		
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> listCustomer = customerjpa.findAll();
		return listCustomer;
	}
	
}
