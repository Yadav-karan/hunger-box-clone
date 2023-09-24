package com.hungerboxclone.hungerbox.service;

import java.util.List;

import com.hungerboxclone.hungerbox.dto.CartDto;
import com.hungerboxclone.hungerbox.entities.Cart;
import com.hungerboxclone.hungerbox.exception.NoSuchCartException;
import com.hungerboxclone.hungerbox.exception.NoSuchCustomerException;
import com.hungerboxclone.hungerbox.exception.NoSuchFoodException;

/**
 * @author karanyad
 * All the cart related operations
 */
public interface CartService {
	
	/**
	 * will delete the existing cart by accepting cart id as parameter
	 */
	boolean deleteCart(int cartId);
	
	/**
	 * will remove the food item from cart by accepting cart id & food id as parameter
	 */
	Cart removeItemFromCart(int foodId,int cartId);
	
	/**
	 * will remove all the existing items from cart
	 */
	Cart removeAllItemsFromCart(int cartId)throws NoSuchCartException;
	
	/**
	 * will add items to cart will accept CartDto as parameter
	 */
	String addToCart(CartDto cartDto) throws NoSuchFoodException,NoSuchCustomerException;
	
	/**
	 * will fetch all the carts present in database
	 */
	List<Cart> getAllCarts();
	
	/**
	 * will fetch the cart present in database accepts cart id as parameter
	 */
	Cart getCartById(int cartId) throws NoSuchCartException; 
}
