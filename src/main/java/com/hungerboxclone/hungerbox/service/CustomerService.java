package com.hungerboxclone.hungerbox.service;

import java.util.List;

import com.hungerboxclone.hungerbox.dto.CustomerDto;
import com.hungerboxclone.hungerbox.entities.Cart;
import com.hungerboxclone.hungerbox.entities.Order;
import com.hungerboxclone.hungerbox.exception.NoSuchCartException;
import com.hungerboxclone.hungerbox.exception.NoSuchCustomerException;

public interface CustomerService {

	/**
	 * will add new customer to database
	 */
	CustomerDto addCustomer(CustomerDto customerDto);
	
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
	
	/**
	 * will fetch customers cart from database by accepting id in parameter throws NoSuchCartException when cart is not present associated with customer
	 */
	Cart findCartByCustomerId(int customerId) throws NoSuchCartException;
	
	/**
	 * will fetch customers order from database by accepting id in parameter customer id 
	 */
	List<Order> findOrdersByCustomerId(int customerId);
}
