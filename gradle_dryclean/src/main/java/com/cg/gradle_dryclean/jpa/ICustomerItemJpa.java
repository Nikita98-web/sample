package com.cg.gradle_dryclean.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.gradle_dryclean.models.Customer;
import com.cg.gradle_dryclean.models.CustomerItem;



public interface ICustomerItemJpa extends JpaRepository<CustomerItem , Long>{
	List<CustomerItem> findByCustomer(Customer customer);
}
