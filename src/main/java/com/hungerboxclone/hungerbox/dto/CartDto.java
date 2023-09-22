package com.hungerboxclone.hungerbox.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hungerboxclone.hungerbox.entities.Customer;
import com.hungerboxclone.hungerbox.entities.Food;

public class CartDto {

	@JsonProperty("food_id")
	private Food foodItems;
	@JsonProperty("customer_id")
	private Customer customer;

	public CartDto() {
		
	}
	public CartDto(Food foodItems, Customer customer) {
		super();
		this.foodItems = foodItems;
		this.customer = customer;
	}
	public Food getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(Food foodItems) {
		this.foodItems = foodItems;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CartDto [foodItems=" + foodItems + ", customer=" + customer + "]";
	}
	
}
