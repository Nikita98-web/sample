package com.cg.gradle_dryclean.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gradle_dryclean.models.CustomerItem;
import com.cg.gradle_dryclean.repository.ICustomerItemRepository;


@Service
public class CustomerItemService implements ICustomerItemService {
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerItemService.class);
	@Autowired
	private ICustomerItemRepository customerItemRepository;
	
	//Add item
	public CustomerItem addItem(CustomerItem item) {
		LOGGER.info("customerItem service - addItem method executed");
		return customerItemRepository.addItem(item);
	}
	
	//Remove Item by id
	public CustomerItem removeItem(long id) throws Exception{
		LOGGER.info("customerItem service - removeItem method executed");
		return customerItemRepository.removeItem(id);
	}
	
	//Update item by id
	public CustomerItem updateItem(long id, CustomerItem item)throws Exception {
		LOGGER.info("customerItem service - updateItemr method executed");
		return customerItemRepository.updateItem(id, item);
	}
	
	//Get item by id
	public CustomerItem getItem(long id) throws Exception{
		LOGGER.info("customerItem service - getItem method executed");
		return customerItemRepository.getItem(id);
	}
	
	//Get items by customer
	public List<CustomerItem> getItemsByCustomer(long customerId)throws Exception{
		LOGGER.info("customerItem service - getItemsByCustomer Customer method executed");
		return customerItemRepository.getItemsByCustomer(customerId);
	}
}
