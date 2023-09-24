package com.hungerboxclone.hungerbox.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class FoodItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodItemId;
	private int quantity;
	@OneToOne
	private Food food;
	
	public FoodItem() {
		
	}

	public FoodItem(int foodItemId, int quantity, Food food) {
		super();
		this.foodItemId = foodItemId;
		this.quantity = quantity;
		this.food = food;
	}
	
	public FoodItem(int quantity, Food food) {
		this.quantity = quantity;
		this.food = food;
	}

	public int getFoodItemId() {
		return foodItemId;
	}
	public void setFoodItemId(int foodItemId) {
		this.foodItemId = foodItemId;
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
		return "FoodItem [FoodItemId=" + foodItemId + ", quantity=" + quantity + ", food=" + food + "]";
	}
	
}
