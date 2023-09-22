package com.hungerboxclone.hungerbox.service;

import java.util.List;

import com.hungerboxclone.hungerbox.dto.OrderDto;
import com.hungerboxclone.hungerbox.entities.Order;

public interface OrderService {

	/**
	 * will place order by accepting OrderDto
	 */
	Order placeOrder(OrderDto orderDto);
	/**
	 * will cancel order by accepting Order id
	 */
	boolean cancelOrder(int orderId);
	/**
	 * will update order by accepting status (this action will be performed by vendor)
	 */
	Order updateOrder(String status);
	/**
	 * will fetch all the orders from database
	 */
	List<Order> getAllOrders();
}
