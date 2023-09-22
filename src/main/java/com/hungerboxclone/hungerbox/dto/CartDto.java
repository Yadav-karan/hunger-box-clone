package com.hungerboxclone.hungerbox.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hungerboxclone.hungerbox.entities.Customer;
import com.hungerboxclone.hungerbox.entities.Food;

public class CartDto {

	@JsonProperty("food_id")
	private int foodItem;
	@JsonProperty("customer_id")
	private int customer;

	public CartDto() {
		
	}

	public int getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(int foodItem) {
		this.foodItem = foodItem;
	}

	public int getCustomer() {
		return customer;
	}

	public void setCustomer(int customer) {
		this.customer = customer;
	}
	
}
