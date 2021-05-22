package com.cg.gradle_dryclean;

import java.time.LocalDate;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.gradle_dryclean.exception.*;

import com.cg.gradle_dryclean.models.*;
import com.cg.gradle_dryclean.services.ICustomerService;

@SpringBootTest
public class CustomerServiceTest {
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceTest.class);
	@Autowired
	private ICustomerService customerService;
	
	Address address=null;
	Customer customer=null;
	
	@BeforeAll
	public static void init() {
	}
	
	@Test
	public void addCustomerTest01() {
		LOGGER.info("addCustomerTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("7","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		assertNotNull (customerService.addCustomer(customer));	
	}
	
	@Test
	public void updateCustomerTest01() throws NotFoundException{
		LOGGER.info("updateCustomerTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		try {
			customerService.updateCustomer(234, customer);
		}
		catch(NotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
	@Test
	public void updateCustomerTest02() throws NotFoundException{
		LOGGER.info("updateCustomerTest02 method executed");
		address=new Address("a-605","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Gaurav","gaurav@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		try {
		assertNotNull(customerService.updateCustomer(6, customer));
		}
		catch(NotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void removeCustomerTest01() throws NotFoundException{
		LOGGER.info("removeCustomerTest01 method executed");
		try {
			customerService.removeCustomer(456);
		}
		catch(NotFoundException ex) {
		assertEquals("Customer id not found",ex.getMessage());
		}
		
	}
	@Test
	public void removeCustomerTest02() throws NotFoundException{
		LOGGER.info("removeCustomerTest02 method executed");
		try {
			customerService.removeCustomer(500);
		}
		catch(NotFoundException ex) {
		assertEquals("Customer id not found",ex.getMessage());
		}
		
	}
	
	@Test
	public void getCustomerTest01() throws Exception{
		LOGGER.info("getCustomerTest01 method executed");
		try {
			customerService.getCustomer(345);
		}
		catch(NotFoundException ex) {
			assertEquals("Customer id is not present",ex.getMessage());
		}
	}
	@Test
	public void getCustomerTest02() throws Exception{
		LOGGER.info("getCustomerTest02 method executed");
		try {
		assertNotNull(customerService.getCustomer(1));
		}
		catch(NotFoundException ex) {
			assertEquals("Customer id is not present",ex.getMessage());
		}
	}
	
	@Test
	public void getAllCustomersTest01() {
		LOGGER.info("getAllCustomersTest01 method executed");
		assertNotNull (customerService.getAllCustomers());
	}
	
	
}
