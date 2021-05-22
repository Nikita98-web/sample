package com.cg.gradle_dryclean;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;

import com.cg.gradle_dryclean.controller.BookingController;
import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.models.Address;
import com.cg.gradle_dryclean.models.Booking;
import com.cg.gradle_dryclean.models.Customer;
import com.cg.gradle_dryclean.services.IBookingService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class BookingControllerTest {
	static final Logger LOGGER = LoggerFactory.getLogger(BookingControllerTest.class);
	
	@Autowired
	private BookingController bookingController;
	
	Address address=null;
	Customer customer=null;
	Booking booking=null;
	
	@BeforeAll
	public  void init() {
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		booking=new Booking(35,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customer);
	}
	
	@Test
	public void addBookingTest01() {
		LOGGER.info("addBookingTest01 method executed");
		ResponseEntity<Object> response= bookingController.addBooking(booking);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void updateBookingTest01() throws NotFoundException {
		LOGGER.info("updateBookingTest01 method executed");
		ResponseEntity<Object> response= bookingController.updateBooking(35, booking);
		assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
	}
	
	@Test
	public void getBookingTest01() throws Exception {
		LOGGER.info("getBookingTest01 method executed");
		ResponseEntity<Object> response= bookingController.getBooking(35);
		assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
	}
	
	@Test
	public void getAllBookingTest01() {
		LOGGER.info("getAllBookingTest01 method executed");
		ResponseEntity<Object> response= bookingController.getAllBookings();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		}
	
	@Test
	public void getBookingsByDateTest01() {
		LOGGER.info("getAllBookingTest01 method executed");
		ResponseEntity<Object> response= bookingController.getBookingsByDate("2025-03-04");
		assertEquals(HttpStatus.OK, response.getStatusCode());
		}
	
	@Test
	public void getBookingsByCustomersTest01() throws Exception {
		LOGGER.info("getAllBookingTest01 method executed");
		ResponseEntity<Object> response= bookingController.getBookingsByCustomer(7);
		assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
		}
}
