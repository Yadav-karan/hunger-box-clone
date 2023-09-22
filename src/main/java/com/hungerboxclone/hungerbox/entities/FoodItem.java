package com.hungerboxclone.hungerbox.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FoodItem {

	@Id
	private int FoodItemId;
	private int quantity;
	@OneToOne
	private Food food;
	
	public FoodItem() {
		
	}

	public FoodItem(int foodItemId, int quantity, Food food) {
		super();
		FoodItemId = foodItemId;
		this.quantity = quantity;
		this.food = food;
	}

	public int getFoodItemId() {
		return FoodItemId;
	}
	public void setFoodItemId(int foodItemId) {
		FoodItemId = foodItemId;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "FoodItem [FoodItemId=" + FoodItemId + ", quantity=" + quantity + ", food=" + food + "]";
	}
	
}
