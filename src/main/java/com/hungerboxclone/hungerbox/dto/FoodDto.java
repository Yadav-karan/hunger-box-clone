package com.hungerboxclone.hungerbox.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodDto {
	
	@JsonProperty("food_id")
	private int foodId;
	@JsonProperty("food_name")
	private String foodName;
	@JsonProperty("food_desc")
	private String foodDescription;
	@JsonProperty("food_price")
	private double foodPrice;
	
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodDescription() {
		return foodDescription;
	}
	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	@Override
	public String toString() {
		return "FoodDto [foodName=" + foodName + ", foodDescription=" + foodDescription + ", foodPrice=" + foodPrice
				+ "]";
	}
	
}
