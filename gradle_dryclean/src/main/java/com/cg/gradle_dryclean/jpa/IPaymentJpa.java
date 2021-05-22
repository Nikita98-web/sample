package com.cg.gradle_dryclean.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.gradle_dryclean.models.Payment;


public interface IPaymentJpa extends JpaRepository<Payment,Long> {
	
}
