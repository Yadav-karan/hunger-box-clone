package com.hungerboxclone.hungerbox.service;

import java.util.List;

import com.hungerboxclone.hungerbox.dto.CustomerDto;
import com.hungerboxclone.hungerbox.entities.Customer;
import com.hungerboxclone.hungerbox.exception.NoSuchCustomerException;

public interface CustomerService {

	/**
	 * will add new customer to database
	 */
	Customer addCustomer(CustomerDto customerDto);
	
	/**
	 * will delete customer from database accepts id as parameter throws NoSuchCustomerException if data not found
	 */
	boolean deleteCustomer(int customerId)throws NoSuchCustomerException;
	
	/**
	 * will update customer in database
	 */
	CustomerDto updateCustomer(CustomerDto customerDto);
	
	/**
	 * will fetch all the customer from database
	 */
	List<CustomerDto> getAllCustomer();
	
	/**
	 * will fetch customer from database by accepting id in parameter throws NoSuchCustomerException when customer is not present
	 */
	CustomerDto findCustomerById(int customerId) throws NoSuchCustomerException;
}
