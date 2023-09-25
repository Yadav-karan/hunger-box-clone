package com.hungerboxclone.hungerbox.service;

import java.util.List;

import com.hungerboxclone.hungerbox.dto.OrderUpdateDto;
import com.hungerboxclone.hungerbox.entities.Order;
import com.hungerboxclone.hungerbox.exception.NoSuchOrderException;

public interface OrderService {

	/**
	 * will place order by accepting OrderDto
	 */
	String placeOrder(int customerId);
	/**
	 * will cancel order by accepting Order id
	 */
	boolean cancelOrder(int orderId);
	/**
	 * will update order by accepting status (this action will be performed by vendor)
	 */
	String updateOrder(OrderUpdateDto orderUpdateDto) throws NoSuchOrderException;
	/**
	 * will fetch all the orders from database
	 */
	List<Order> getAllOrders();
	
}
