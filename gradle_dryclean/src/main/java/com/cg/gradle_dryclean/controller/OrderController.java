package com.cg.gradle_dryclean.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gradle_dryclean.models.Order;
import com.cg.gradle_dryclean.services.IOrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private IOrderService orderService;
	
	//Add Order
	@PostMapping("/add")
	public Order addOrder(@RequestBody Order order) {
		LOGGER.info("/Order/add URL is opened");
		LOGGER.info("addOrder method executed");
		return orderService.addOrder(order);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> removeOrder(@PathVariable long id)throws Exception {
		LOGGER.info("/Order/remove/{id} URL is opened");
		LOGGER.info("removeOrder method executed");
		ResponseEntity<Object> response=null;
		Order o= orderService.removeOrder(id);
		response = new ResponseEntity<Object>(o,HttpStatus.OK);
		return response;
	}
	
	//Update Order by id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateOrder(@PathVariable long id,@RequestBody Order order)throws Exception {
		LOGGER.info("/Order/update/{id} URL is opened");
		LOGGER.info("updateOrder method executed");
		ResponseEntity<Object> response=null;
		Order o= orderService.updateOrder(id, order);
		response = new ResponseEntity<Object>(o,HttpStatus.OK);
		return response;
	}
	
	//Get Order by details
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getOrderDetails(@PathVariable long id) throws Exception{
		LOGGER.info("/Order/get/{id}} URL is opened");
		LOGGER.info("Get method executed");
		ResponseEntity<Object> response=null;
		Order o =  orderService.getOrderDetails(id);
		response = new ResponseEntity<Object>(o,HttpStatus.OK);
		return response;
	}
	
	//Get all orders
	@GetMapping("/get")
	public List<Order> getAllOrders(){
		LOGGER.info("/Order/get URL is opened");
		LOGGER.info("Get method executed");
		return orderService.getAllOrders();
	}
}
