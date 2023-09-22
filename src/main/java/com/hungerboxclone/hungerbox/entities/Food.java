package com.hungerboxclone.hungerbox.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodId;
	private String foodName;
	private String foodDescription;
	private double foodPrice;
	@OneToOne(mappedBy = "food")
	private FoodItem foodItem;
	@ManyToMany
	@JoinTable(name="order_food",
			joinColumns = { @JoinColumn(name="food_id")},
			inverseJoinColumns = { @JoinColumn(name="order_id")})
	private List<Order> orders; 
	
	public Food() {
		
	}
	
	public Food(int foodId, String foodName, String foodDescription, double foodPrice) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodDescription = foodDescription;
		this.foodPrice = foodPrice;
	}

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
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodDescription=" + foodDescription
				+ ", foodPrice=" + foodPrice + "]";
	}
	
}
