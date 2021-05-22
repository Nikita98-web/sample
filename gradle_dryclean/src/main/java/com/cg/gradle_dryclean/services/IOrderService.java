package com.cg.gradle_dryclean.services;
import java.util.List;

import com.cg.gradle_dryclean.models.*;

public interface IOrderService {
	Order addOrder(Order order);
	Order removeOrder(long id)throws Exception;
	Order updateOrder(long id, Order order)throws Exception;
	Order getOrderDetails(long id)throws Exception;
	List<Order> getAllOrders();
}
