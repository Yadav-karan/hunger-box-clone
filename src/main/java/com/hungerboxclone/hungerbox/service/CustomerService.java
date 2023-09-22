package com.hungerboxclone.hungerbox.service;

import java.util.List;

import com.hungerboxclone.hungerbox.dto.CustomerDto;
import com.hungerboxclone.hungerbox.entities.Customer;

public interface CustomerService {

	/**
	 * will add new customer to database
	 */
	Customer addCustomer(CustomerDto customerDto);
	
	/**
	 * will delete customer from database
	 */
	boolean deleteCustomer(int customerId);
	
	/**
	 * will update customer in database
	 */
	Customer updateCustomer(CustomerDto customerDto);
	
	/**
	 * will fetch all the customer from database
	 */
	List<Customer> getAllCustomer();
	
}
