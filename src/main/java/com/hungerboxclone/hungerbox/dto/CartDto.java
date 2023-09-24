package com.hungerboxclone.hungerbox.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartDto {

	@JsonProperty("food_id")
	private int foodId;
	@JsonProperty("quantity")
	private int quantity;
	@JsonProperty("customer_id")
	private int customerId;

	public CartDto() {
		
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
