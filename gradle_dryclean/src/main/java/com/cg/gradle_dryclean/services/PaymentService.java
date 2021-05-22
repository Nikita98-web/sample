package com.cg.gradle_dryclean.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gradle_dryclean.models.Payment;
import com.cg.gradle_dryclean.repository.IPaymentRepository;
@Service
public class PaymentService implements IPaymentService{
	static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);
	@Autowired
	private IPaymentRepository paymentRepository;
	
	//Add payment
	public Payment addPayment(Payment payment) {
		LOGGER.info("Payment service - addPayment method executed");
		return paymentRepository.addPayment(payment);	
	}
	
	//Remove payment by id
	public Payment removePayment(long id) throws Exception{
		LOGGER.info("Payment service - removePayment method executed");
		return paymentRepository.removePayment(id);
	}
	
	//Update payment by id
	public Payment updatePayment(long id, Payment payment)throws Exception {
		LOGGER.info("Payment service - updatePayment method executed");
		return paymentRepository.updatePayment(id, payment);
	}
	
	//Get payment details by id
	public Payment getPaymentDetails(long id) throws Exception{
		LOGGER.info("Payment service - getPaymentDetails Payment method executed");
		return paymentRepository.getPaymentDetails(id);
	}
	
	//Get all payment details
	public List<Payment> getAllPaymentDetails(){
		LOGGER.info("Payment service - getAllPaymentDetails Payment method executed");
		return paymentRepository.getAllPaymentDetails();
	}
}
