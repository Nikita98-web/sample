package com.cg.gradle_dryclean.services;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.models.Booking;
import com.cg.gradle_dryclean.repository.IBookingRepository;

@Service
public class BookingService implements IBookingService {
	static final Logger LOGGER = LoggerFactory.getLogger(BookingService.class);
	
	@Autowired
	private IBookingRepository bookingRepository;
	
	//Add Booking of customers
	public Booking addBooking(Booking booking) {
		LOGGER.info("Booking service - addBooking method executed");
		return bookingRepository.addBooking(booking);
	}
	
	//Remove booking of customers
	public Booking removeBooking(long bookingId) throws Exception{
		LOGGER.info("Booking service - removeBooking method executed");
		return bookingRepository.removeBooking(bookingId);
	}
	
	//Update booking from customer id
	public Booking updateBooking(long bookingId, Booking booking)throws NotFoundException {
		LOGGER.info("Booking service - updateBooking method executed");
		return bookingRepository.updateBooking(bookingId, booking);
	}
	
	//Get bookings from booking id
	public Booking getBooking(long bookingId) throws Exception {
		LOGGER.info("Booking service - getBooking method executed");
		return bookingRepository.getBooking(bookingId);
	}
	
	//List of all bookings 
	public List<Booking> getAllBookings(){
		LOGGER.info("Booking service - getAllBooking method executed");
		return bookingRepository.getAllBookings();
	}
	
	//Get bookings by date
	public List<Booking> getBookingsByDate(LocalDate date){
		LOGGER.info("Booking service - getBookingsbyDate method executed");
		return bookingRepository.getBookingsByDate(date);
	}
	
	//Get all bookings by customer
	public List<Booking>getBookingsByCustomer(long customerId)throws Exception{
		LOGGER.info("Booking service - getBookingsByCustomer method executed");
		return bookingRepository.getBookingsByCustomer(customerId);
	}
}
