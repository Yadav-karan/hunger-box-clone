package com.hungerboxclone.hungerbox.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.hungerboxclone.hungerbox.dto.CustomerDto;
import com.hungerboxclone.hungerbox.dto.FoodDto;
import com.hungerboxclone.hungerbox.entities.Customer;
import com.hungerboxclone.hungerbox.entities.Food;

public class Utils {

	private static final String DATE_FORMAT = "dd-MM-yyyy";
	
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
		food.setFoodDescription(foodDto.getFoodDescription());
		food.setFoodPrice(foodDto.getFoodPrice());
		return food;
	}
	
	public static FoodDto parseFoodToFoodDto(Food food) {
		FoodDto foodDto = new FoodDto();
		foodDto.setFoodId(food.getFoodId());
		foodDto.setFoodName(food.getFoodName());
		foodDto.setFoodDescription(food.getFoodDescription());
		foodDto.setFoodPrice(food.getFoodPrice());
		return foodDto;
	}
	
	public static List<FoodDto> parseListOfFoodToListOfFoodDto(List<Food> foods){
		List<FoodDto> foodDtos = new ArrayList<>();
		foods.stream().forEach(f->{
			foodDtos.add(parseFoodToFoodDto(f));
		});
		return foodDtos;
	}
	
	public static String parseToDateTimeToString(LocalDateTime date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return dateTimeFormatter.format(date);
    }
}
