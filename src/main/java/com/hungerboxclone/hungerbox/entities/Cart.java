package com.hungerboxclone.hungerbox.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	@OneToMany(cascade = CascadeType.ALL)
	private List<FoodItem> foodItems;
	@OneToOne(mappedBy = "cart")
	@JoinColumn(name="customer_id")
	@JsonBackReference
	private Customer customer;
	public Cart() {
		
	}

	public Cart(int cartId, List<FoodItem> foodItems) {
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

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
