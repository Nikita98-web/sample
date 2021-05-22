package com.cg.gradle_dryclean;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.cg.gradle_dryclean.controller.CustomerController;
import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.models.Address;
import com.cg.gradle_dryclean.models.Customer;
import com.cg.gradle_dryclean.services.ICustomerService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerControllerTest {
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerControllerTest.class);
	@Autowired
	private CustomerController customerController;
	
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
		assertEquals(customerController.addCustomer(customer).getStatusCode(), HttpStatus.CREATED);
	}

	@Test
	public void updateCustomerTest01() throws NotFoundException{
		LOGGER.info("updateCustomerTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("7","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		assertEquals(customerController.updateCustomer(6, customer).getStatusCode(), HttpStatus.ACCEPTED);
	}
	
	@Test
	public void getCustomerTest01() throws Exception{
		LOGGER.info("getCustomerTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("7","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		assertEquals(customerController.getCustomer(1).getStatusCode(), HttpStatus.ACCEPTED);
	}
	
	@Test
	public void getAllCustomerTest01() {
		LOGGER.info("getAllCustomerTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("7","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		assertEquals(customerController.getAllCustomers().getStatusCode(), HttpStatus.OK);
	}
	
}
