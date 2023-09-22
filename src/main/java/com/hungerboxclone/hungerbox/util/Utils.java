package com.hungerboxclone.hungerbox.util;

import java.util.ArrayList;
import java.util.List;

import com.hungerboxclone.hungerbox.dto.CustomerDto;
import com.hungerboxclone.hungerbox.dto.FoodDto;
import com.hungerboxclone.hungerbox.entities.Customer;
import com.hungerboxclone.hungerbox.entities.Food;

public class Utils {

	public static Customer parseCustomerDtoToCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDto.getCustomerId());
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setUsername(customerDto.getUsername());
		customer.setEmail(customerDto.getEmail());
		customer.setContactNumber(customerDto.getContactNumber());
		return customer;
	}
	
	public static CustomerDto parseCustomerToCustomerDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setUsername(customer.getUsername());
		customerDto.setEmail(customer.getEmail());
		customerDto.setContactNumber(customer.getContactNumber());
		customerDto.setPassword("#NA");
		return customerDto;
	}
	
	public static List<CustomerDto> parseListofCustomerToCustomerDto(List<Customer> customers){
		List<CustomerDto> customerDtos = new ArrayList<>();
		customers.stream().forEach(c->{
			customerDtos.add(parseCustomerToCustomerDto(c));
		});
		return customerDtos;
	}
	
	public static Food parseFoodDtoToFood(FoodDto foodDto) {
		Food food = new Food();
		food.setFoodId(foodDto.getFoodId());
		food.setFoodName(foodDto.getFoodName());
		food.setFoodDescription(food.getFoodDescription());
		food.setFoodPrice(foodDto.getFoodPrice());
		return food;
	}
}
