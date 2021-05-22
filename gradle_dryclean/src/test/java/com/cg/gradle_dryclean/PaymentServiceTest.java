package com.cg.gradle_dryclean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.models.Address;
import com.cg.gradle_dryclean.models.Booking;
import com.cg.gradle_dryclean.models.Card;
import com.cg.gradle_dryclean.models.Customer;
import com.cg.gradle_dryclean.models.Payment;
import com.cg.gradle_dryclean.services.IBookingService;
import com.cg.gradle_dryclean.services.IPaymentService;

@SpringBootTest
public class PaymentServiceTest {
	static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceTest.class);
	@Autowired
	private IPaymentService paymentService;
	
	
	Payment payment=null;
	Card card=null;
	
	@Test
	public void addPaymentTest01() {
		LOGGER.info("addPaymentTest01 method executed");
		card=new Card(2,"MasterCard","1234567889567",LocalDate.parse("2026-09-06"),"SBI");
		payment=new Payment(4,"Online","Completed",card);
		assertNotNull (paymentService.addPayment(payment));
	}
	
	@Test
	public void removePaymentTest01() throws Exception{
		LOGGER.info("removePaymentTest01 method executed");
		try {
			paymentService.removePayment(584);
		}
		catch(NotFoundException ex) {
		assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void removePaymentTest02() throws Exception{
		LOGGER.info("removePaymentTes02 method executed");
		try {
			paymentService.removePayment(450);
		}
		catch(NotFoundException ex) {
		assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void updatePaymentTest01() throws Exception{
		LOGGER.info("updatePaymentTest01 method executed");
		card=new Card(2,"MasterCard","1234567889567",LocalDate.parse("2026-09-06"),"SBI");
		payment=new Payment(8,"Online","Completed",card);
		try {
		assertNotNull(paymentService.updatePayment(8, payment));
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void updatePaymentTest02() throws Exception{
		LOGGER.info("updatePaymentTest02 method executed");
		card=new Card(2,"MasterCard","1234567889567",LocalDate.parse("2026-09-06"),"SBI");
		payment=new Payment(4,"Online","Completed",card);
		try {
			paymentService.updatePayment(234, payment);
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getPaymentTest01() throws Exception{
		LOGGER.info("getPaymentTest01 method executed");
		try {
			paymentService.getPaymentDetails(356);
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	@Test
	public void getPaymentTest02() throws Exception{
		LOGGER.info("getPaymentTest02 method executed");
		try {
			assertNotNull(paymentService.getPaymentDetails(8));
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getAllPaymentDetailsTest01() {
		LOGGER.info("getAllPaymentDetailsTest01 method executed");
		assertNotNull (paymentService.getAllPaymentDetails());
	}
}
