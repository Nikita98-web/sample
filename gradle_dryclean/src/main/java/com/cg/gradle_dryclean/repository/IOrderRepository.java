package com.cg.gradle_dryclean.repository;

import java.util.List;

import com.cg.gradle_dryclean.models.Order;

public interface IOrderRepository {
	Order addOrder(Order order);
	Order removeOrder(long id)throws Exception;
	Order updateOrder(long id, Order order)throws Exception;
	Order getOrderDetails(long id)throws Exception;
	List<Order> getAllOrders();
}
