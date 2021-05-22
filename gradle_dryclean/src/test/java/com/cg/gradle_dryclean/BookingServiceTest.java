package com.cg.gradle_dryclean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import static org.hamcrest.MatcherAssert.*;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.gradle_dryclean.services.IBookingService;

import static org.hamcrest.CoreMatchers.*;

import com.cg.gradle_dryclean.controller.OrderController;
import com.cg.gradle_dryclean.exception.*;

import com.cg.gradle_dryclean.models.*;
import com.cg.gradle_dryclean.services.*;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class BookingServiceTest {
	static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceTest.class);

	@Autowired
	private IBookingService bookingService;
	
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
		assertNotNull (bookingService.addBooking(booking));
	}
	
	
	
	@Test
	public void updateBookingTest01() throws NotFoundException{
		LOGGER.info("updateBookingTest01 method executed");
		try {
			bookingService.updateBooking(234, booking);
		}
		catch(NotFoundException ex) {
			assertEquals("Booking Id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void updateBookingTest02() throws NotFoundException{
		LOGGER.info("updateBookingTest02 method executed");
		try {
		assertNotNull(bookingService.updateBooking(35, booking));
		}
		catch(NotFoundException ex) {
			assertEquals("Booking Id is not valid",ex.getMessage());
		}
		
	}
	
	@Test
	public void getBookingTest01() throws Exception{
		LOGGER.info("getBookingTest01 method executed");
		try {
			bookingService.getBooking(123);
		}
		catch(NotFoundException ex) {
			assertEquals("Booking id is not valid",ex.getMessage());
		}
	}
	@Test
	public void getBookingTest02() throws Exception{
		LOGGER.info("getBookingTest02 method executed");
			try {
			assertNotNull(bookingService.getBooking(35));
			}
			catch(NotFoundException ex) {
				assertEquals("Booking id is not valid",ex.getMessage());
			}
		
	}
	
	@Test
	public void getAllBookingsTest01() {
		LOGGER.info("getAllBookingsest01 method executed");
		assertNotNull (bookingService.getAllBookings());
	}
	
	@Test
	public void getBookingsByDate01() {
		LOGGER.info("getBookingsByDate01 method executed");
			List<Booking> lb=(bookingService.getBookingsByDate(LocalDate.parse("2025-03-04")));
			assertThat(lb, IsEmptyCollection.empty());
			
	}
	
	@Test
	public void getBookingsByDate02() {
		LOGGER.info("getBookingsByDate02 method executed");
			List<Booking> lb=(bookingService.getBookingsByDate(LocalDate.parse("2026-02-05")));
			assertThat(lb, IsEmptyCollection.empty());
			
	}
	
	@Test
	public void removeBookingTest01() throws Exception{
		LOGGER.info("removeBookingTest01 method executed");
		try {
			bookingService.removeBooking(678);
		}
		catch(NotFoundException ex) {
		assertEquals("Booking id is not valid",ex.getMessage());
		}
	
	}
	@Test
	public void removeBookingTest02() throws Exception{
		LOGGER.info("removeBookingTest02 method executed");
		try {
			bookingService.removeBooking(500);
		}
		catch(NotFoundException ex) {
		assertEquals("Booking id is not valid",ex.getMessage());
		}
	
	}
	
	
}
