package com.cg.gradle_dryclean.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.jpa.*;
import com.cg.gradle_dryclean.models.Booking;
import com.cg.gradle_dryclean.models.Customer;


@Repository
public class BookingRepository implements IBookingRepository {
	
	@Autowired
	private IBookingJpa bookingjpa;
	
	@Autowired
	private ICustomerJpa customerjpa;
	
	public Booking addBooking(Booking booking) {
		 bookingjpa.save(booking);
		 return booking;
	}
	
	public Booking removeBooking(long bookingId) throws Exception{
		Optional<Booking> ob=bookingjpa.findById(bookingId);
		if(ob.isPresent()) {
			Booking b= ob.get();
			bookingjpa.delete(b);
			return b;
		}
		else
			throw new NotFoundException("Booking id is not valid");
	}
	
	public Booking updateBooking(long bookingId, Booking booking) throws NotFoundException{
Optional<Booking> ob = bookingjpa.findById(bookingId);
		
		if(ob.isPresent()) {
			
		Booking b= ob.get();
		b.setBookingId(booking.getBookingId());
		b.setBookingDate(booking.getBookingDate());
		b.setBookingTime(booking.getBookingTime());
		b.setCustomerDetails(booking.getCustomerDetails());
		b.setServiceType(booking.getServiceType());
		bookingjpa.save(b);
		return b;
	}
		else
			throw new NotFoundException("Booking Id is not valid");
	}
	
	public Booking getBooking(long bookingId) throws Exception {
		Optional<Booking> ob = bookingjpa.findById((bookingId));
		if(ob.isPresent()) {
			Booking b=ob.get();
			return b;
		}
		else 
			throw new NotFoundException("Booking id is not valid");
		
	}
	
	public List<Booking> getAllBookings(){
		List<Booking> b=bookingjpa.findAll();
		return b;
	}
	
	public List<Booking> getBookingsByDate(LocalDate date){
		List<Booking> b = bookingjpa.findByBookingDate(date);
		return b;
	}
	
	public List<Booking> getBookingsByCustomer(long customerId) throws Exception{
		Optional<Customer> oc = customerjpa.findById(Long.toString(customerId));
		if(oc.isPresent()) {
			Customer c = oc.get();
			return bookingjpa.findByCustomerDetails(c);
		}
		else 
			throw new NotFoundException("customer id is not valid");
		
	}
}
