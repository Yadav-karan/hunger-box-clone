package com.hungerboxclone.hungerbox.util;

import com.hungerboxclone.hungerbox.dto.CustomerDto;
import com.hungerboxclone.hungerbox.entities.Customer;

public class Utils {

	public static Customer parseCustomerDtoToCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setUsername(customerDto.getUsername());
		customer.setEmail(customerDto.getEmail());
		customer.setContactNumber(customerDto.getContactNumber());
		return customer;
	}
}
