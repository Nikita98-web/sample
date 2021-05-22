package com.cg.gradle_dryclean.jpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.gradle_dryclean.models.Booking;
import com.cg.gradle_dryclean.models.Customer;



public interface IBookingJpa extends JpaRepository<Booking, Long> {
	List<Booking> findByBookingDate(LocalDate date);
	List<Booking> findByCustomerDetails(Customer customer);
}
