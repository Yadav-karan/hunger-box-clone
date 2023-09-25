package com.hungerboxclone.hungerbox.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="order_tbl")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private double totalPrice;
	private String orderDate;
	private String status;
	@ManyToOne
	@JsonBackReference
	private Customer customer;
	@ManyToMany
	private List<FoodItem> foodItems;
	
	public Order() {
		
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + ", status="
				+ status + ", customer=" + customer + ", foodItems=" + foodItems + "]";
	}
	
}
