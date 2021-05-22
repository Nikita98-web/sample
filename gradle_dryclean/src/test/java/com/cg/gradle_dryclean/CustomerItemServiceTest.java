package com.cg.gradle_dryclean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.models.Address;
import com.cg.gradle_dryclean.models.Booking;
import com.cg.gradle_dryclean.models.Customer;
import com.cg.gradle_dryclean.models.CustomerItem;
import com.cg.gradle_dryclean.services.*;

@SpringBootTest
public class CustomerItemServiceTest {
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerItemServiceTest.class);
	@Autowired
	private ICustomerItemService customerItemService;
	
	CustomerItem customerItem=null;
	Address address=null;
	Customer customer=null;
	
	@Test
	public void removeItemTest01() throws Exception{
		LOGGER.info("removeItemTest01 method executed");
		try {
			customerItemService.removeItem(746);
		}
		catch(NotFoundException ex) {
		assertEquals("Customer item is not valid",ex.getMessage());
		}
	}
	@Test
	public void removeItemTest02() throws Exception{
		LOGGER.info("removeItemTest02 method executed");
		try {
			customerItemService.removeItem(115);
		}
		catch(NotFoundException ex) {
		assertEquals("Customer item is not valid",ex.getMessage());
		}
	}
	
		@Test
		public void getItemTest01() throws Exception{
			LOGGER.info("getItemTest01 method executed");
			try {
				customerItemService.getItem(987);
			}
			catch(NotFoundException ex) {
				assertEquals("CustomerItem is not valid",ex.getMessage());
			}
		}
		@Test
		public void getItemTest02() throws Exception{
			LOGGER.info("getItemTest02 method executed");
			try {
			assertNotNull(customerItemService.getItem(1));
			}
			catch(NotFoundException ex) {
				assertEquals("CustomerItem is not valid",ex.getMessage());
			}
		}
		
		@Test
		public void getBookingsByCustomerTest01() throws Exception {
			LOGGER.info("getBookingsByCustomerTest01 method executed");
			try {
			      customerItemService.getItemsByCustomer(789);
			}
			catch(NotFoundException ex) {
				assertEquals("Customerid is not valid",ex.getMessage());
			}	
		}
		@Test
		public void getBookingsByCustomerTest02() throws Exception{
			LOGGER.info("getBookingsByCustomerTest02 method executed");
			try {
			assertThat(customerItemService.getItemsByCustomer(3),IsEmptyCollection.empty());
			}
			catch(NotFoundException ex) {
				assertEquals("Customerid is not valid",ex.getMessage());
			}	
		}
		
		@Test
		public void updateCustomerItemTest01() throws Exception{
			LOGGER.info("updateCustomerItemTest01 method executed");
			address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
			customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
			customerItem=new CustomerItem(1,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
			try {
				customerItemService.updateItem(658, customerItem);
			}
			catch(NotFoundException ex) {
				assertEquals("CustomerItem is not valid",ex.getMessage());
			}
		}
		
		@Test
		public void updateCustomerItemTest02() throws Exception{
			LOGGER.info("updateCustomerItemTest02 method executed");
			address=new Address("d-210","Balewadi","Baner","Pune","Maharashtra",12345);
			customer=new Customer("7","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
			customerItem=new CustomerItem(6,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
			try {
			assertNotNull(customerItemService.updateItem(6, customerItem));
			}
			catch(NotFoundException ex) {
				assertEquals("CustomerItem is not valid",ex.getMessage());
			}
		}
		
		@Test
		public void addItemTest01() {
			LOGGER.info("addItemTest01 method executed");
			address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
			customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
			customerItem=new CustomerItem(1,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
			assertNotNull (customerItemService.addItem(customerItem));
		}
		
	}

	
