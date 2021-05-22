package com.cg.gradle_dryclean.services;
import java.util.List;

import com.cg.gradle_dryclean.models.*;

public interface ICustomerItemService {
	CustomerItem addItem(CustomerItem item);
	CustomerItem removeItem(long id)throws Exception;
	CustomerItem updateItem(long id, CustomerItem item)throws Exception;
	CustomerItem getItem(long id)throws Exception;
	List<CustomerItem> getItemsByCustomer(long customerId)throws Exception;
}