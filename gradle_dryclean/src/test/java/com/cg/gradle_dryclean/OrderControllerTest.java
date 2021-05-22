package com.cg.gradle_dryclean;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.cg.gradle_dryclean.controller.OrderController;
import com.cg.gradle_dryclean.models.Address;
import com.cg.gradle_dryclean.models.Booking;
import com.cg.gradle_dryclean.models.Customer;
import com.cg.gradle_dryclean.models.Order;
import com.cg.gradle_dryclean.services.IOrderService;

@SpringBootTest
public class OrderControllerTest {
	static final Logger LOGGER = LoggerFactory.getLogger(OrderControllerTest.class);
	@Autowired
	private OrderController orderController;
	
	Address address=null;
	Customer customer=null;
	Booking booking=null;
	Order order=null;
	
	@Test
	public void addOrderTest01() {
		LOGGER.info("addOrderTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customer);
		order=new Order(1,5000.00,LocalDate.parse("2021-05-03"),customer,"Online",booking);
		assertEquals (orderController.addOrder(order).getStatusCode(),HttpStatus.CREATED);
	}
	
	@Test
	public void updateOrderTest01() throws Exception{
		LOGGER.info("updateOrderTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customer);
		order=new Order(1,5000.00,LocalDate.parse("2021-05-03"),customer,"Online",booking);
		assertEquals (orderController.updateOrder(15, order).getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	public void getOrderDetailsTest01() throws Exception{
		LOGGER.info("getOrderDetailsTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customer);
		order=new Order(1,5000.00,LocalDate.parse("2021-05-03"),customer,"Online",booking);
		assertEquals (orderController.getOrderDetails(10).getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	public void getAllOrdersTest01(){
		LOGGER.info("getAllOrderTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customer);
		order=new Order(1,5000.00,LocalDate.parse("2021-05-03"),customer,"Online",booking);
		assertEquals (orderController.getAllOrders().getStatusCode(),HttpStatus.OK);
	}
}
