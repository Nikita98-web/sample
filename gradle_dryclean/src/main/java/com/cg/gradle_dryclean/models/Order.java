package com.cg.gradle_dryclean.models;

import java.time.LocalDate;

import javax.persistence.*;
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private long orderId;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="billing_date")
	private LocalDate billingDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Customer customer;
	
	@Column(name="payment_method")
	private String paymentMethod;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private Booking bookingDetails;
	
	public Order() {
		
	}
	
	public Order(long orderId, double amount, LocalDate billingDate, Customer customer, String paymentMethod,
			Booking bookingDetails) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer = customer;
		this.paymentMethod = paymentMethod;
		this.bookingDetails = bookingDetails;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Booking getBookingDetails() {
		return bookingDetails;
	}
	public void setBookingDetails(Booking bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
}
