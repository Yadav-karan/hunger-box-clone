package com.hungerboxclone.hungerbox.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hungerboxclone.hungerbox.dto.CartDto;
import com.hungerboxclone.hungerbox.entities.Cart;
import com.hungerboxclone.hungerbox.entities.Customer;
import com.hungerboxclone.hungerbox.entities.Food;
import com.hungerboxclone.hungerbox.entities.FoodItem;
import com.hungerboxclone.hungerbox.exception.NoSuchCustomerException;
import com.hungerboxclone.hungerbox.exception.NoSuchFoodException;
import com.hungerboxclone.hungerbox.repo.CartRepo;
import com.hungerboxclone.hungerbox.repo.CustomerRepo;
import com.hungerboxclone.hungerbox.repo.FoodItemRepo;
import com.hungerboxclone.hungerbox.repo.FoodRepo;

public class CartServiceImpl implements CartService {
	
	@Autowired
	private FoodRepo foodRepo;
	
	@Autowired
	private FoodItemRepo foodItemRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private CustomerRepo customerRepo; 

	@Override
	public boolean deleteCart(int cartId) {
		return false;
	}

	@Override
	public Cart removeItemFromCart(int foodId, int cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart removeAllItemsFromCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addToCart(CartDto cartDto) {
		// Finding food from the DB
		Food food = foodRepo.findById(cartDto.getFoodId()).
				orElseThrow(()-> new NoSuchFoodException("Food with food id: "+cartDto.getFoodId()+" not found"));
		
		// Creating object of FoodItem to set in cart
		FoodItem foodItem = new FoodItem(cartDto.getQuantity(), food);
		
		//Creating object of customer to set in cart
		Customer customer = customerRepo.findById(cartDto.getCustomerId())
				.orElseThrow(()-> new NoSuchCustomerException("Customer with customer id: "+cartDto.getCustomerId()+" not found!!"));
		
		// if customer does not have associated with him a cart
		if(customer.getCart() == null) {
			Cart cart = new Cart();
			List<FoodItem> foodItems = new ArrayList<>();
			foodItems.add(foodItem);
			cart.setFoodItems(foodItems);
			
			//Setting cart for customer and 
			customer.setCart(cart);
			customerRepo.save(customer);
			cart.setCustomer(customer);

			//setting the customer for cart and saving it
			cartRepo.save(cart);
			return "Food Added to cart";
		} else {
			// Fetching cart from the customer if he is 
			Cart cart = customer.getCart();
			List<FoodItem> foodItems = cart.getFoodItems();
			foodItems.add(foodItem);
			cart.setFoodItems(foodItems);
			
			//Setting cart for customer and saving it
			customer.setCart(cart);
			customerRepo.save(customer);
			
			//setting the customer for cart and saving it
			cart.setCustomer(customer);
			cartRepo.save(cart);
			return "Food Added to cart";
		}
	}

	@Override
	public List<Cart> getAllCarts() {
		// TODO Auto-generated method stub
		return null;
	}

}
