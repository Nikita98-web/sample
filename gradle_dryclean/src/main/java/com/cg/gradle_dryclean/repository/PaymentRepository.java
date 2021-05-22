package com.cg.gradle_dryclean.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.jpa.IPaymentJpa;
import com.cg.gradle_dryclean.models.Payment;
@Repository
public class PaymentRepository implements IPaymentRepository {
	@Autowired
	private IPaymentJpa paymentjpa;
	
	public Payment addPayment(Payment payment) {
		paymentjpa.save(payment);
		return payment;
	}
	
	public Payment removePayment(long id) throws Exception{
		Optional<Payment> op = paymentjpa.findById(id);
		if(op.isPresent()) {
			Payment p = op.get();
			return p;
		}
		else 
			throw new NotFoundException("Payment id is not valid");
	}
	
	public Payment getPaymentDetails(long id) throws Exception{
		Optional<Payment> op = paymentjpa.findById(id);
		if(op.isPresent()) {
			Payment p = op.get();
			return p;
		}
		else 
			throw new NotFoundException("Payment id is not valid");
	}
	
	public List<Payment> getAllPaymentDetails(){
		List<Payment> p = paymentjpa.findAll();
		return p; 
	}
	
	public Payment updatePayment(long id, Payment payment)throws Exception{
		Optional<Payment> op = paymentjpa.findById(id);
		if(op.isPresent()) {
			Payment p = op.get();
			p.setPaymentId(payment.getPaymentId());
			p.setCard(payment.getCard());
			p.setStatus(payment.getStatus());
			p.setType(payment.getType());
			paymentjpa.save(p);
			return p;
		}
		else
			throw new NotFoundException("Payment id is not valid");
	}
}
