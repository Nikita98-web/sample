package com.cg.gradle_dryclean.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.jpa.IOrderJpa;
import com.cg.gradle_dryclean.models.Order;
@Repository
public class OrderRepository implements IOrderRepository{
	@Autowired
	private IOrderJpa orderjpa;
	
	public Order addOrder(Order order) {
		orderjpa.save(order);
		return order;
	}
	
	public Order removeOrder(long id) throws Exception{
		Optional<Order> oo=orderjpa.findById(id);
		if(oo.isPresent()) {
			Order o = oo.get();
			orderjpa.delete(o);
			return o;
		}
		else
			throw new NotFoundException("Order id is not valid");
		
	}
	
	public Order updateOrder(long id, Order order)throws Exception {
		Optional<Order> oo=orderjpa.findById(id);
		if(oo.isPresent()) {
			Order o=oo.get();
			o.setOrderId(order.getOrderId());
			o.setAmount(order.getAmount());
			o.setBillingDate(order.getBillingDate());
			o.setBookingDetails(order.getBookingDetails());
			o.setCustomer(order.getCustomer());
			o.setPaymentMethod(order.getPaymentMethod());
			orderjpa.save(o);
			return o;
		}
		else
			throw new NotFoundException("Order id is not valid");
		
	}
	
	public Order getOrderDetails(long id)throws Exception {
	    Optional<Order> oo=orderjpa.findById(id);
	    if(oo.isPresent()) {
	    	Order o=oo.get();
	    	return o;
	    }
	    else
	    	throw new NotFoundException("Order id is not valid");
	}
	
	public List<Order> getAllOrders(){
		List<Order> o = orderjpa.findAll();
		return o;
	}
}
