package com.cg.gradle_dryclean.services;
import java.util.List;

import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.models.*;

public interface ICustomerService {
	Customer addCustomer(Customer customer);
	Customer removeCustomer(long custId)throws NotFoundException;
	Customer updateCustomer(long custId, Customer customer)throws NotFoundException;
	Customer getCustomer(long custId)throws Exception;
	List<Customer> getAllCustomers();
}
