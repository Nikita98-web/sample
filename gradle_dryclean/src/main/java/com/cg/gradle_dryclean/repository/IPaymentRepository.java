package com.cg.gradle_dryclean.repository;

import java.util.List;

import com.cg.gradle_dryclean.models.Payment;

public interface IPaymentRepository {
	Payment addPayment(Payment payment);
	Payment removePayment(long id)throws Exception;
	Payment updatePayment(long id, Payment payment)throws Exception;
	Payment getPaymentDetails(long id)throws Exception;
	List<Payment> getAllPaymentDetails();
}
