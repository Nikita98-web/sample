package com.cg.gradle_dryclean.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gradle_dryclean.models.Order;
import com.cg.gradle_dryclean.repository.IOrderRepository;
@Service
public class OrderService implements IOrderService{
	static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
	@Autowired
	private IOrderRepository orderRepository;
	
	//Add order
	public Order addOrder(Order order) {
		LOGGER.info("Order service - addOrder method executed");
		return orderRepository.addOrder(order);
	}
	
	//Remove order by id
	public Order removeOrder(long id) throws Exception{
		LOGGER.info("Order service - removeOrder method executed");
		return orderRepository.removeOrder(id);
	}
	
	//Update order by id
	public Order updateOrder(long id, Order order)throws Exception {
		LOGGER.info("Order Iservice - updateOrder method executed");
		return orderRepository.updateOrder(id, order);
	}
	
	//Get Order details by id
	public Order getOrderDetails(long id)throws Exception {
		LOGGER.info("Order service - getOrder method executed");
		return orderRepository.getOrderDetails(id);
	}
	
	//Get all orders
	public List<Order> getAllOrders(){
		LOGGER.info("Order service - getAllOrder method executed");
		return orderRepository.getAllOrders();
	}
}
