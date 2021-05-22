package com.cg.gradle_dryclean.controller;

import java.time.LocalDate;
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
import com.cg.gradle_dryclean.models.Booking;
import com.cg.gradle_dryclean.services.IBookingService;



@RestController
@RequestMapping("/bookings")
public class BookingController {

	
	static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);
	@Autowired
	private IBookingService bookingService;
	
	//Add a booking
	@PostMapping("/add")
	public Booking addBooking(@RequestBody Booking booking) {
		LOGGER.info("/bookings/add URL is opened");
		LOGGER.info("add Booking method executed");
		return bookingService.addBooking(booking);
		
	}
	//Remove all the booking by id
	@DeleteMapping("/remove/{bookingId}")
	public ResponseEntity<Object> removeBooking(@PathVariable long bookingId) throws Exception {
		LOGGER.info("/bookings/add URL is opened");
		LOGGER.info("RemoveBooking method executed");
		ResponseEntity<Object> response=null;
		Booking b = bookingService.removeBooking(bookingId);
		response=new ResponseEntity<Object>(b,HttpStatus.OK);
		return response;
	}
	
	//Update all the booking by id
	@PutMapping("/update/{bookingId}")
	public ResponseEntity<Object> updateBooking(@PathVariable long bookingId, @RequestBody Booking booking) throws NotFoundException {
		LOGGER.info("/bookings//update/{bookingId} URL is opened");
		LOGGER.info("add Booking method executed");
		ResponseEntity<Object>response=null;
		Booking b = bookingService.updateBooking(bookingId, booking);
		response=new ResponseEntity<>(b, HttpStatus.ACCEPTED);
		return response;
}

	//Get by booking id
	@GetMapping("/get/{bookingId}")
	public ResponseEntity <Object> getBooking(@PathVariable long bookingId) throws Exception{
		LOGGER.info("/bookings///get/{bookingId} URL is opened");
		LOGGER.info("Get Booking method executed");
		ResponseEntity <Object>response=null;
		Booking b=bookingService.getBooking(bookingId);
		response=new ResponseEntity<>(b, HttpStatus.ACCEPTED);		
		return response;
	}
	//Get all the bookings
	@GetMapping("/get")
	public List<Booking> getAllBookings(){
		LOGGER.info("/bookings/add URL is opened");
		LOGGER.info("getAllBookings method executed");
		return bookingService.getAllBookings();
	}
	
	//Get all the bookings for a specific date
	@GetMapping("/getbydate/{date}")
	public List<Booking> getBookingsByDate(@PathVariable String date){
		LOGGER.info("/bookings/getbydate/"+date+ " URL is opened");
		LOGGER.info("getbydate method executed");
		LocalDate myDate=LocalDate.parse(date);
		return bookingService.getBookingsByDate(myDate);
	}
	
	//Get bookings by customer id
	@GetMapping("/getbycustomer/{customerId}")
	public ResponseEntity<Object> getBookingsByCustomer(@PathVariable long customerId) throws Exception{
		LOGGER.info("/bookings/getbycustomer/{customerId} URL is opened");
		LOGGER.info("getbycustomer method executed");
		ResponseEntity<Object>response=null;
		List<Booking> lb=bookingService.getBookingsByCustomer(customerId);
		response=new ResponseEntity<>(lb, HttpStatus.ACCEPTED);		
		return response;
	}
	
}
