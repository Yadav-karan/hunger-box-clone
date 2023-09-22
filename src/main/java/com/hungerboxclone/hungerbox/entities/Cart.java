package com.hungerboxclone.hungerbox.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	@OneToMany(mappedBy = "cart")
	private List<Food> foodItems;
	@OneToOne(mappedBy = "cart")
	@JoinColumn(name="customer_id")
	private Customer customer;
	public Cart() {
		
	}

	public Cart(int cartId, List<Food> foodItems) {
		super();
		this.cartId = cartId;
		this.foodItems = foodItems;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<Food> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<Food> foodItems) {
		this.foodItems = foodItems;
	}
	
}
